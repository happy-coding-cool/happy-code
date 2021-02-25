package cool.happycoding.code.web.jackson2.deserializer;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.ClassUtil;
import cool.happycoding.code.base.util.DateUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:22 下午
 */
public class Jackson2LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonToken token = jsonParser.getCurrentToken();
        if (token == JsonToken.VALUE_STRING) {
            String localDateTime = jsonParser.getText().trim();
            if (StrUtil.isNotBlank(localDateTime)) {
                String pattern = DateUtils.datePattern(localDateTime);
                if (StrUtil.isNotBlank(pattern)) {
                    return LocalDateTimeUtil.parse(localDateTime, pattern);
                }
            }
        }

        if (token == JsonToken.VALUE_NUMBER_INT) {
            return new Timestamp(jsonParser.getLongValue()).toLocalDateTime();
        }

        throw JsonMappingException.from(jsonParser,
                String.format("Cannot deserialize instance of %s out of %s token",
                        ClassUtil.nameOf(handledType()), token));
    }

    @Override
    public Class<?> handledType() {
        return LocalDateTime.class;
    }
}
