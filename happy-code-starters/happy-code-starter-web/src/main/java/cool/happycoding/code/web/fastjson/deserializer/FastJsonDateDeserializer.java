package cool.happycoding.code.web.fastjson.deserializer;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:11 下午
 */
public class FastJsonDateDeserializer implements ObjectDeserializer {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        Object value = parser.parse();
        if (value==null){
            return null;
        }
        String dateStr = String.valueOf(value);
        return (T) DateUtil.parse(dateStr).toJdkDate();
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
