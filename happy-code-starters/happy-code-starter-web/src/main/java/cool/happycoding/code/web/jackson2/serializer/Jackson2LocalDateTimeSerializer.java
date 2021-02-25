package cool.happycoding.code.web.jackson2.serializer;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:33 下午
 */
public class Jackson2LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private final String dateFormat;

    public Jackson2LocalDateTimeSerializer(String dateFormat){
        this.dateFormat = dateFormat;
    }


    @Override
    public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (value == null) {
            jgen.writeNull();
        } else {
            jgen.writeString( LocalDateTimeUtil.format(value, dateFormat));
        }
    }

    @Override
    public Class<LocalDateTime> handledType() {
        return LocalDateTime.class;
    }

}
