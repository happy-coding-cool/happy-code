package cool.happycoding.code.web.jackson2.serializer;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:32 下午
 */
public class Jackson2BigDecimalAsPlainSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal bigDecimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (ObjectUtil.isNotNull(bigDecimal)){
            jsonGenerator.writeString(bigDecimal.toPlainString());
        }
    }

    @Override
    public Class<BigDecimal> handledType() {
        return BigDecimal.class;
    }
}
