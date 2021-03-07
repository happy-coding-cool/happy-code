package cool.happycoding.code.validator.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * description
 *
 * @author lanlanhappy 2021/03/07 9:06 下午
 */
@Documented
@Retention(RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Constraint(validatedBy = { SexValidator.class })
public @interface Sex {

    /**
     * 是否不允许为空 {@linkplain NotNull}
     * @return 默认：true
     */
    boolean notNull() default true;

    String message() default "性别必须为:男/女";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
