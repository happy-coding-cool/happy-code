package cool.happycoding.code.web.jackson2.serializer;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import cool.happycoding.code.base.util.DateUtils;

import java.io.IOException;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:32 下午
 */
public class Jackson2DateSerializer extends JsonSerializer<Date> {

    private final String dateFormat;
    public Jackson2DateSerializer(String dateFormat){
        this.dateFormat = dateFormat;
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (ObjectUtil.isNotNull(date)){
            jsonGenerator.writeString(DateUtils.format(date, dateFormat));
        }
    }

    @Override
    public Class<Date> handledType() {
        return Date.class;
    }

}
