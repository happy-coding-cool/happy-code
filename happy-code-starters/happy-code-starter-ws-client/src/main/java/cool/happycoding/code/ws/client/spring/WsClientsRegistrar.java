package cool.happycoding.code.ws.client.spring;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Lists;
import cool.happycoding.code.ws.client.annotation.EnableWsClients;
import cool.happycoding.code.ws.client.annotation.WsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.util.*;
import java.util.stream.Stream;

/**
 * description
 *
 * @author lanlanhappy 2021/11/27 8:59 下午
 */
@Slf4j
public class WsClientsRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

    private static final String BASE_PACKAGE = "basePackages";

    private Environment environment;
    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        registerFeignClients(metadata, registry);
    }

    public void registerFeignClients(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {

        LinkedHashSet<BeanDefinition> candidateComponents = new LinkedHashSet<>();
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(this.resourceLoader);
        scanner.addIncludeFilter(new AnnotationTypeFilter(WsClient.class));
        Set<String> basePackages = getBasePackages(metadata);
        basePackages.forEach(basePackage->candidateComponents.addAll(scanner.findCandidateComponents(basePackage)));
        List<String> classNames = Lists.newArrayList();
        candidateComponents.stream()
                .filter(candidateComponent -> candidateComponent instanceof AnnotatedBeanDefinition)
                .map(candidateComponent -> (AnnotatedBeanDefinition)candidateComponent)
                .forEach(beanDefinition ->{
                    AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                    Assert.isTrue(annotationMetadata.isInterface(), "@WsClient can only be specified on an interface");
                    classNames.add(annotationMetadata.getClassName());
                    registerFeignClient(registry, annotationMetadata);
                });
        log.info("scan ws-client: {}", classNames.size());
        classNames.forEach(name->log.info("ws client:{}", name));
    }

    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    protected Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata
                .getAnnotationAttributes(EnableWsClients.class.getCanonicalName());
        Set<String> basePackages = new HashSet<>();
        if (CollUtil.isNotEmpty(attributes)) {
            String[] packages = (String[]) attributes.get(BASE_PACKAGE);
            Stream.of(packages)
                    .filter(StringUtils::hasText)
                    .forEach(basePackages::add);
        }
        if (basePackages.isEmpty()) {
            basePackages.add(ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }
        return basePackages;
    }

    private void registerFeignClient(BeanDefinitionRegistry registry, AnnotationMetadata annotationMetadata) {
        String className = annotationMetadata.getClassName();
        Class<?> clazz = ClassUtils.resolveClassName(className, ClassUtils.getDefaultClassLoader());
        WsClientFactoryBean<?> factoryBean = new WsClientFactoryBean<>(clazz);
        BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(factoryBean.getClass());
        definition.setLazyInit(true);
        definition.addConstructorArgValue(clazz);
        definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        BeanDefinitionHolder holder = new BeanDefinitionHolder(definition.getBeanDefinition(), generatorBeanName(clazz));
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
        WsClientDescriptorCache.put(clazz);
    }

    public String generatorBeanName(Class<?> clz) {
        String shortClassName = ClassUtils.getShortName(clz.getSimpleName());
        return "wsClient"+ Introspector.decapitalize(shortClassName);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
