package cool.happycoding.validator.annotation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author other
 */
@SuppressWarnings("all")
public class IPV4Validator implements ConstraintValidator<IPV4, String> {

	private boolean notNull;
	
	@Override
	public void initialize(IPV4 constraintAnnotation) {
		this.notNull = constraintAnnotation.notNull();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StrUtil.isNotBlank(value)) {
			return Validator.isIpv4(value);
		}
		
		if (notNull) {
			return false;
		}
		
		return true;
	}
	
}
