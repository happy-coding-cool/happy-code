package cool.happycoding.code.web;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * description
 *
 * @author lanlanhappy 2021/09/28 2:12 下午
 */
public final class MessageHolder {

    private static MessageSource messageSource;

    public MessageHolder(MessageSource messageSource) {
        MessageHolder.messageSource = messageSource;
    }

    /**
     * 获取单个国际化翻译值
     */
    public static String getMessage(String code) {
        return getMessage(code, null);
    }

    public static String getMessage(String code, Object[] args) {
        try {
            return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            return code;
        }
    }
}
