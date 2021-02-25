package cool.happycoding.code.web.jackson2;

import cool.happycoding.code.web.HappyWebProperties;
import cool.happycoding.code.web.jackson2.deserializer.Jackson2DateDeserializer;
import cool.happycoding.code.web.jackson2.deserializer.Jackson2LocalDateTimeDeserializer;
import cool.happycoding.code.web.jackson2.serializer.Jackson2BigDecimalAsPlainSerializer;
import cool.happycoding.code.web.jackson2.serializer.Jackson2DateSerializer;
import cool.happycoding.code.web.jackson2.serializer.Jackson2LocalDateTimeSerializer;
import cool.happycoding.code.web.jackson2.serializer.Jackson2LongAsPlainSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * description
 *
 * @author lanlanhappy 2021/02/25 9:21 下午
 */
public class CustomerJackson2Config implements Jackson2ObjectMapperBuilderCustomizer {

    private final HappyWebProperties happyWebProperties;

    public CustomerJackson2Config(HappyWebProperties happyWebProperties){
        this.happyWebProperties = happyWebProperties;
    }

    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {

        if (happyWebProperties.getDeserializer().isEnableDate()){
            jacksonObjectMapperBuilder.deserializers(new Jackson2DateDeserializer());
            jacksonObjectMapperBuilder.deserializers(new Jackson2LocalDateTimeDeserializer());
        }
        if (happyWebProperties.getSerializer().isEnableDate()){
            jacksonObjectMapperBuilder.serializers(new Jackson2DateSerializer(happyWebProperties.getSerializer().getDateFormat()));
            jacksonObjectMapperBuilder.serializers(new Jackson2LocalDateTimeSerializer(happyWebProperties.getSerializer().getDateFormat()));
        }
        if (happyWebProperties.getSerializer().isEnableBigDecimalAsPlain()){
            jacksonObjectMapperBuilder.serializers(new Jackson2BigDecimalAsPlainSerializer());
        }

        if (happyWebProperties.getSerializer().isEnableLongAsPlain()){
            jacksonObjectMapperBuilder.serializers(new Jackson2LongAsPlainSerializer());
        }
    }
}
