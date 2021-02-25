package cool.happycoding.code.web.jackson2.serializer;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.Set;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:34 下午
 */
public class Jackson2LongAsPlainSerializer extends JsonSerializer<Long> {
    /**
     * 排除 分页参数的序列化
     */
    private final Set<String> excludeFieldNames = Sets.newHashSet("current", "pages", "size");

    @Override
    public void serialize(Long value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        String fieldName = jsonGenerator.getOutputContext().getCurrentName();
        // 对long类型强制转化成string
        if(!excludeFieldNames.contains(StrUtil.toString(fieldName))){
            jsonGenerator.writeString(Long.toString(value));
        }else{
            jsonGenerator.writeNumber(value);
        }
    }
}
