package cool.happycoding.validator.annotation;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;


public class BirthdayValidator implements ConstraintValidator<Birthday, Object> {

	private boolean notNull;
	
	@Override
	public void initialize(Birthday constraintAnnotation) {
		this.notNull = constraintAnnotation.notNull();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String validValue = null;
		if (value instanceof String) {
			validValue = (String) value;
		} else if (value instanceof Date) {
			validValue = DateUtil.formatDate((Date) value);
		} else if (value instanceof TemporalAccessor) {
			validValue = DateTimeFormatter.ofPattern("yyyy-MM-dd").format((TemporalAccessor) value);
		}
		
		if (StrUtil.isNotBlank(validValue)) {
			return Validator.isBirthday(validValue);
		}
		
		if (notNull) {
			return false;
		}
		
		return true;
	}
	
}
