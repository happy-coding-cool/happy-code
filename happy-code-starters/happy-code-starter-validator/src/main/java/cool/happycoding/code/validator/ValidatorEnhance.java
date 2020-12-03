package cool.happycoding.code.validator;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.common.HappyStatus;
import cool.happycoding.code.base.exception.BizException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

/**
 * description
 *
 * @author lanlanhappy 2020/12/01 9:37 下午
 */
@Slf4j
public class ValidatorEnhance {

    private Object param;
    private final javax.validation.Validator validator;

    public ValidatorEnhance(javax.validation.Validator validator){
        this.validator = validator;
    }

    /**
     * 异常提示
     */
    private static final String NOT_NULL_HINT_MSG = "参数 {} 必须不为 null";
    private static final String NOT_EMPTY_HINT_MSG = "参数 {} 必须不为empty(null 或 \"\")";
    private static final String ASSERT_TRUE_HINT_MSG = "参数 {} 必须为 true";
    private static final String ASSERT_FALSE_HINT_MSG = "参数 {} 必须为 false";
    private static final String DIGITS_HINT_MSG = "参数 {} 必须是一个数字，其值必须在 {} - {} 之间（包含）";
    private static final String MAX_HINT_MSG = "参数 {} 不能超过最大值：{}";
    private static final String MIN_HINT_MSG = "参数 {} 不能低于最小值：{}";
    private static final String LENGTH_HINT_MSG = "参数 {} 长度必须在 {} - {} 之间（包含）";
    private static final String CHINESE_HINT_MSG = "参数 {} 中文校验不通过";
    private static final String ENGLISH_HINT_MSG = "参数 {} 英文校验不通过";
    private static final String BIRTHDAY_HINT_MSG = "参数 {} 生日校验不通过";
    private static final String CELLPHONE_HINT_MSG = "参数 {} 不是一个合法的手机号码";
    private static final String EMAIL_HINT_MSG = "参数 {} 不是一个合法的邮箱格式";
    private static final String ID_CARD_HINT_MSG = "参数 {} 不是一个合法的身份证号码";
    private static final String PLATE_NUMBER_HINT_MSG = "参数 {} 不是一个合法的中国车牌号码";
    private static final String UUID_HINT_MSG = "参数 {} 不是一个合法的UUID";
    private static final String URL_HINT_MSG = "参数 {} 不是一个合法的URL";
    private static final String IPV4_HINT_MSG = "参数 {} 不是一个合法的IPV4地址";
    private static final String IPV6_HINT_MSG = "参数 {} 不是一个合法的IPV6地址";
    private static final String MAC_ADDRESS_HINT_MSG = "参数 {} 不是一个合法的MAC地址";
    private static final String REGEX_HINT_MSG = "参数 {} 不满足正则表达式：{}";

    /**
     * 切换校验对象
     *
     * @param param 校验对象
     * @return Validator
     */
    public ValidatorEnhance param(Object param) {
        this.param = param;
        return this;
    }

    /**
     * 必须不为 {@code null}
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance notNull(String paramName) {
        cn.hutool.core.lang.Validator.validateNotNull(param, StrUtil.format(NOT_NULL_HINT_MSG, paramName));
        return this;
    }

    /**
     * 必须不为empty(null 或 "")
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance notEmpty(String paramName) {
        cn.hutool.core.lang.Validator.validateNotEmpty(param, StrUtil.format(NOT_EMPTY_HINT_MSG, paramName));
        return this;
    }

    /**
     * 必须为 true
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance assertTrue(String paramName) {
        cn.hutool.core.lang.Validator.validateTrue((boolean) param, StrUtil.format(ASSERT_TRUE_HINT_MSG, paramName));
        return this;
    }

    /**
     * 必须为 false
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance assertFalse(String paramName) {
        cn.hutool.core.lang.Validator.validateFalse((boolean) param, StrUtil.format(ASSERT_FALSE_HINT_MSG, paramName));
        return this;
    }

    /**
     * 必须是一个数字，其值必须在可接受的范围内（包含）
     *
     * @param min 最小值
     * @param max 最大值
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance digits(Number min, Number max, String paramName) {
        cn.hutool.core.lang.Validator.validateBetween((Number) param, min, max,	StrUtil.format(DIGITS_HINT_MSG, paramName, min, max));
        return this;
    }

    /**
     * 最大值校验
     *
     * @param max 最大值
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance max(Number max, String paramName) {
        BigDecimal bigNum1 = NumberUtil.toBigDecimal((Number) param);
        BigDecimal bigNum2 = NumberUtil.toBigDecimal(max);
        if (!NumberUtil.isLessOrEqual(bigNum1, bigNum2)) {
            throw new ValidateException(StrUtil.format(MAX_HINT_MSG, paramName, max));
        }
        return this;
    }

    /**
     * 最小值校验
     *
     * @param min 最小值
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance min(Number min, String paramName) {
        BigDecimal bigNum1 = NumberUtil.toBigDecimal((Number) param);
        BigDecimal bigNum2 = NumberUtil.toBigDecimal(min);

        if (!NumberUtil.isGreaterOrEqual(bigNum1, bigNum2)) {
            throw new ValidateException(StrUtil.format(MIN_HINT_MSG, paramName, min));
        }
        return this;
    }

    /**
     * 长度校验
     *
     * @param min 最小长度
     * @param max 最大长度
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance length(int min, int max, String paramName) {
        int length = ObjectUtil.length(param);
        if (!(length >= min && length <= max)) {
            throw new ValidateException(StrUtil.format(LENGTH_HINT_MSG, paramName, min, max));
        }

        return this;
    }

    /**
     * 中文校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance chinese(String paramName) {
        cn.hutool.core.lang.Validator.validateChinese((CharSequence) param, StrUtil.format(CHINESE_HINT_MSG, paramName));
        return this;
    }

    /**
     * 英文校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance english(String paramName) {
        cn.hutool.core.lang.Validator.validateWord((CharSequence) param, StrUtil.format(ENGLISH_HINT_MSG, paramName));
        return this;
    }

    /**
     * 生日校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance birthday(String paramName) {
        String date = null;
        if (param instanceof String) {
            date = (String) param;
        } else if (param instanceof Date) {
            date = DateUtil.formatDate((Date) param);
        } else if (param instanceof LocalDate || param instanceof LocalDateTime) {
            date = DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate) param);
        } else {
            throw new BizException(HappyStatus.REQUEST_VALIDATION_FAILED.getCode(), StrUtil.format("参数 {} 未知类型，不支持生日校验", paramName));
        }
        cn.hutool.core.lang.Validator.validateBirthday(date, StrUtil.format(BIRTHDAY_HINT_MSG, paramName));
        return this;
    }

    /**
     * 手机号校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance cellphone(String paramName) {
        cn.hutool.core.lang.Validator.validateMobile((CharSequence) param, StrUtil.format(CELLPHONE_HINT_MSG, paramName));
        return this;
    }

    /**
     * 邮箱校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance email(String paramName) {
        cn.hutool.core.lang.Validator.validateEmail((CharSequence) param, StrUtil.format(EMAIL_HINT_MSG, paramName));
        return this;
    }

    /**
     * 身份证校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance idCard(String paramName) {
        cn.hutool.core.lang.Validator.validateCitizenIdNumber((CharSequence) param, StrUtil.format(ID_CARD_HINT_MSG, paramName));
        return this;
    }

    /**
     * 中国车牌号校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance plateNumber(String paramName) {
        cn.hutool.core.lang.Validator.validatePlateNumber((CharSequence) param, StrUtil.format(PLATE_NUMBER_HINT_MSG, paramName));
        return this;
    }

    /**
     * UUID校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance uuid(String paramName) {
        cn.hutool.core.lang.Validator.validateUUID((CharSequence) param, StrUtil.format(UUID_HINT_MSG, paramName));
        return this;
    }

    /**
     * URL校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance url(String paramName) {
        cn.hutool.core.lang.Validator.validateUrl((CharSequence) param, StrUtil.format(URL_HINT_MSG, paramName));
        return this;
    }

    /**
     * IPV4地址校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance ipv4(String paramName) {
        cn.hutool.core.lang.Validator.validateIpv4((CharSequence) param, StrUtil.format(IPV4_HINT_MSG, paramName));
        return this;
    }

    /**
     * IPV6地址校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance ipv6(String paramName) {
        cn.hutool.core.lang.Validator.validateIpv6((CharSequence) param, StrUtil.format(IPV6_HINT_MSG, paramName));
        return this;
    }

    /**
     * MAC地址校验
     *
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance macAddress(String paramName) {
        cn.hutool.core.lang.Validator.validateMac((CharSequence) param, StrUtil.format(MAC_ADDRESS_HINT_MSG, paramName));
        return this;
    }

    /**
     * 正则校验
     *
     * @param regex 正则表达式
     * @param paramName 参数名
     * @return Validator
     */
    public ValidatorEnhance regex(String regex, String paramName) {
        cn.hutool.core.lang.Validator.validateMatchRegex(regex, (CharSequence) param, StrUtil.format(REGEX_HINT_MSG, paramName, regex));
        return this;
    }

    /**
     * POJO对象校验（通过注解）
     *
     * @param param 校验对象
     * @return Validator
     */
    public ValidatorEnhance valid(Object param) {
        Set<ConstraintViolation<Object>> violations = validator.validate(param);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        return this;
    }

}
