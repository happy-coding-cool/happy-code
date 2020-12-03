package cool.happycoding.code.validator.annotation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author other
 */
public class EnglishValidator implements ConstraintValidator<English, String> {

	private boolean notNull;
	
	@Override
	public void initialize(English constraintAnnotation) {
		this.notNull = constraintAnnotation.notNull();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StrUtil.isNotBlank(value)) {
			return Validator.isWord(value);
		}
		
		if (notNull) {
			return false;
		}
		
		return true;
	}
	
}
