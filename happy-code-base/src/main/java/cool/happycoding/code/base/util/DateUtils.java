package cool.happycoding.code.base.util;

import cn.hutool.core.date.DateUtil;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:23 下午
 */
public final class DateUtils extends DateUtil {

    private final static Map<String, String> PATTERN_MATCH = new HashMap<>(5);

    static {
        PATTERN_MATCH.put("yyyy-MM", "[0-9]{4}-[0-9]{1,2}");
        PATTERN_MATCH.put("yyyy-MM-dd", "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}");
        PATTERN_MATCH.put("yyyy-MM-dd HH:mm", "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}");
        PATTERN_MATCH.put("yyyy-MM-dd HH:mm:ss", "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}");
        PATTERN_MATCH.put("yyyy-MM-dd HH:mm:ss.sss", "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}.[0-9]{1,3}");
    }
    private static String patterMatcher(String format){
        String pattern = null;
        for (Map.Entry<String, String> entry : PATTERN_MATCH.entrySet()) {
            if (Pattern.compile(entry.getValue()).matcher(format).matches()) {
                pattern = entry.getKey();
                break;
            }
        }
        return pattern;
    }

    public static String datePattern(String dateVal){
        String pattern = patterMatcher(dateVal);
        if (pattern == null){
            return null;
        }
        return pattern;
    }

}
