package cool.happycoding.code.web.jackson2;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.google.common.collect.Lists;
import cool.happycoding.code.web.HappyWebProperties;
import cool.happycoding.code.web.jackson2.deserializer.Jackson2DateDeserializer;
import cool.happycoding.code.web.jackson2.deserializer.Jackson2LocalDateTimeDeserializer;
import cool.happycoding.code.web.jackson2.serializer.Jackson2BigDecimalAsPlainSerializer;
import cool.happycoding.code.web.jackson2.serializer.Jackson2DateSerializer;
import cool.happycoding.code.web.jackson2.serializer.Jackson2LocalDateTimeSerializer;
import cool.happycoding.code.web.jackson2.serializer.Jackson2LongAsPlainSerializer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:21 下午
 */
@Setter
@Getter
public class CustomerJackson2Config implements Jackson2ObjectMapperBuilderCustomizer {

    private final HappyWebProperties happyWebProperties;

    private List<JsonDeserializer<?>> jsonDeserializers = Lists.newArrayList();

    private List<JsonSerializer<?>> jsonSerializers = Lists.newArrayList();

    public CustomerJackson2Config(HappyWebProperties happyWebProperties){
        this.happyWebProperties = happyWebProperties;
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {

        if (happyWebProperties.getDeserializer().isEnableDate()){
            jsonDeserializers.add(new Jackson2DateDeserializer());
            jsonDeserializers.add(new Jackson2LocalDateTimeDeserializer());
        }
        if (happyWebProperties.getSerializer().isEnableDate()){
            jsonSerializers.add(new Jackson2DateSerializer(happyWebProperties.getSerializer().getDateFormat()));
            jsonSerializers.add(new Jackson2LocalDateTimeSerializer(happyWebProperties.getSerializer().getDateFormat()));
        }
        if (happyWebProperties.getSerializer().isEnableBigDecimalAsPlain()){
            jsonSerializers.add(new Jackson2BigDecimalAsPlainSerializer());
        }
        if (happyWebProperties.getSerializer().isEnableLongAsPlain()){
            jsonSerializers.add(new Jackson2LongAsPlainSerializer());
        }

        if (CollUtil.isNotEmpty(jsonDeserializers)){
            jacksonObjectMapperBuilder.deserializers(jsonDeserializers.toArray(new JsonDeserializer<?>[0]));
        }
        if (CollUtil.isNotEmpty(jsonSerializers)){
            jacksonObjectMapperBuilder.serializers(jsonSerializers.toArray(new JsonSerializer<?>[0]));
        }
    }
}
