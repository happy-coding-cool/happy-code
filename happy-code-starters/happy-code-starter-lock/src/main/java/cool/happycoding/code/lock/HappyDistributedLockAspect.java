package cool.happycoding.code.lock;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.exception.BizException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Objects;

/**
 * description
 *
 * @author lanlanhappy 2021/04/29 4:36 下午
 */
public class HappyDistributedLockAspect {

    private final HappyDistributedLock happyDistributedLock;

    /**
     * 用于SpEL表达式解析.
     */
    private final SpelExpressionParser spelExpressionParser;
    /**
     * 用于获取方法参数定义名字.
     */
    private final DefaultParameterNameDiscoverer nameDiscoverer;

    public HappyDistributedLockAspect(HappyDistributedLock happyDistributedLock){
        this.happyDistributedLock = happyDistributedLock;
        this.spelExpressionParser = new SpelExpressionParser();
        this.nameDiscoverer = new DefaultParameterNameDiscoverer();
    }

    @Around("@annotation(cool.happycoding.code.lock.HLock)")
    public Object invoke(ProceedingJoinPoint joinPoint, HLock hLock){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        String key = getKey(joinPoint, methodSignature, hLock);
        boolean lock = hLock.tryLock() ? happyDistributedLock.tryLock(key,
                        hLock.waitTime(), hLock.leaseTime(), hLock.timeUnit(), hLock.fairLock()) :
                         happyDistributedLock.lock(key, hLock.leaseTime(), hLock.timeUnit(), hLock.fairLock());
        try {
             if (lock){
                return joinPoint.proceed();
             }else {
                if (hLock.throwException()){
                    throw new BizException("Acquire distribute lock fail");
                }
                return null;
             }
        }catch (Throwable throwable){
            throw new BizException(throwable.getMessage());
        }finally {
            happyDistributedLock.unlock(key);
        }
    }

    private String getKey(ProceedingJoinPoint joinPoint, MethodSignature methodSignature, HLock hLock){
        String key = hLock.key();
        String lockKey = null;
        if (StrUtil.startWith(key,"#")){
            Object[] args = joinPoint.getArgs();
            lockKey = getKeyBySpEl(key, methodSignature, args);
        }
        if (StrUtil.isBlank(lockKey)){
            // 类名(含包名):方法名
            lockKey = StrUtil.concat(false,
                    joinPoint.getTarget().getClass().getName(),":", methodSignature.getMethod().getName());
        }
        return lockKey;
    }

    private String getKeyBySpEl(String spEL, MethodSignature methodSignature, Object[] args){
        String[] paramNames = nameDiscoverer.getParameterNames(methodSignature.getMethod());
        if (paramNames != null && paramNames.length > 0) {
            Expression expression = spelExpressionParser.parseExpression(spEL);
            // spring的表达式上下文对象
            EvaluationContext context = new StandardEvaluationContext();
            // 给上下文赋值
            for(int i = 0; i < args.length; i++) {
                context.setVariable(paramNames[i], args[i]);
            }
            if (!Objects.isNull(expression.getValue(context))){
                return Objects.requireNonNull(expression.getValue(context)).toString();
            }
        }
        return null;
    }
}
