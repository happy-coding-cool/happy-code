package cool.happycoding.code.validator.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证是否为生日<br>
 * 只支持以下几种格式：
 * <ul>
 * <li>yyyyMMdd</li>
 * <li>yyyy-MM-dd</li>
 * <li>yyyy/MM/dd</li>
 * <li>yyyyMMdd</li>
 * <li>yyyy年MM月dd日</li>
 * </ul>
 * @author other
 */
@Documented
@Retention(RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Constraint(validatedBy = { BirthdayValidator.class })
public @interface Birthday {

	/**
	 * 是否不允许为空 {@linkplain NotNull}
	 * @return 默认：true
	 */
	boolean notNull() default true;
	
	String message() default "不是一个合法的生日日期格式";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
