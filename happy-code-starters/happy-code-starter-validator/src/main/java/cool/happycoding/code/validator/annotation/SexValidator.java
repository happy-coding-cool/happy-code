package cool.happycoding.code.validator.annotation;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * description
 *
 * @author lanlanhappy 2021/03/07 9:07 下午
 */
public class SexValidator implements ConstraintValidator<Sex, String> {
    private boolean notNull;

    @Override
    public void initialize(Sex constraintAnnotation) {
        this.notNull = constraintAnnotation.notNull();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (StrUtil.isNotBlank(value)) {
            return StrUtil.equalsAnyIgnoreCase("男", "女");
        }

        if (notNull) {
            return false;
        }

        return true;
    }
}
