package cool.happycoding.code.validator.annotation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author other
 */
public class ChineseValidator implements ConstraintValidator<Chinese, Object> {

	private boolean notNull;
	
	@Override
	public void initialize(Chinese constraintAnnotation) {
		this.notNull = constraintAnnotation.notNull();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String validValue = null;
		if (condition(value)) {
			validValue = StrUtil.toString(value);
		}
		if (StrUtil.isNotBlank(validValue)) {
			return Validator.isChinese(validValue);
		}
		if (notNull) {
			return false;
		}
		return true;
	}

	private boolean condition(Object value){
		return (CharUtil.isChar(value) && !CharUtil.isBlankChar((char) value))
				|| (value instanceof String && StrUtil.isNotBlank((String) value));
	}
	
}
