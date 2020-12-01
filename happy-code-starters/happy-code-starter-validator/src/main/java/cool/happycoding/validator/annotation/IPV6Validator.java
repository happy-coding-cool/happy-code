package cool.happycoding.validator.annotation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class IPV6Validator implements ConstraintValidator<IPV6, String> {

	private boolean notNull;
	
	@Override
	public void initialize(IPV6 constraintAnnotation) {
		this.notNull = constraintAnnotation.notNull();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StrUtil.isNotBlank(value)) {
			return Validator.isIpv6(value);
		}
		
		if (notNull) {
			return false;
		}
		
		return true;
	}
	
}
