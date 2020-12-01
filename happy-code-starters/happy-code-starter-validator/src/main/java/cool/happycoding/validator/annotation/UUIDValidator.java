package cool.happycoding.validator.annotation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UUIDValidator implements ConstraintValidator<UUID, String> {

	private boolean notNull;
	
	@Override
	public void initialize(UUID constraintAnnotation) {
		this.notNull = constraintAnnotation.notNull();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StrUtil.isNotBlank(value)) {
			return Validator.isUUID(value);
		}
		
		if (notNull) {
			return false;
		}
		
		return true;
	}
	
}
