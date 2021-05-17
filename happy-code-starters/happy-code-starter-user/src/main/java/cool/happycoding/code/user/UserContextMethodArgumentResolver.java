package cool.happycoding.code.user;

import cn.hutool.core.bean.BeanUtil;
import cool.happycoding.code.base.user.User;
import cool.happycoding.code.user.context.UserContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * description
 *
 * @author lanlanhappy 2020/12/04 9:54 下午
 */
public class UserContextMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class)
                && parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return BeanUtil.copyProperties(UserContextHolder.getUser(), parameter.getParameterType());
    }
}
