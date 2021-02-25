package cool.happycoding.code.web.jackson2.deserializer;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:21 下午
 */
public class Jackson2DateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();
        return DateUtil.parse(date).toJdkDate();
    }

    @Override
    public Class<?> handledType() {
        return Date.class;
    }
}
