package cool.happycoding.web.fastjson;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import cool.happycoding.web.HappyWebProperties;
import cool.happycoding.web.fastjson.deserializer.FastJsonDateDeserializer;
import cool.happycoding.web.fastjson.serializer.FastJsonBigDecimalAsPlainSerializer;
import cool.happycoding.web.fastjson.serializer.FastJsonDateSerializer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:09 下午
 */
public class CustomerFastJsonConfig {

    private final HappyWebProperties happyWebProperties;

    public CustomerFastJsonConfig(HappyWebProperties happyWebProperties){
        this.happyWebProperties = happyWebProperties;
    }

    public FastJsonConfig fastJsonConfig(){
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat(happyWebProperties.getSerializer().getDateFormat());
        fastJsonConfig.setSerializerFeatures(
                // 对输出的json进行格式美化
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                // 用枚举toString()值输出
                SerializerFeature.WriteEnumUsingToString,
                // 关闭循环检查
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat
        );

        // fastjson 自定义反序列化类
        if (happyWebProperties.getDeserializer().isEnableDate()){
            fastJsonConfig.getParserConfig().putDeserializer(Date.class, new FastJsonDateDeserializer());
        }
        if (happyWebProperties.getSerializer().isEnableDate()){
            fastJsonConfig.getSerializeConfig().put(Date.class, new FastJsonDateSerializer(happyWebProperties.getSerializer().getDateFormat()));
        }
        if (happyWebProperties.getSerializer().isEnableBigDecimalAsPlain()){
            fastJsonConfig.getSerializeConfig().put(BigDecimal.class, new FastJsonBigDecimalAsPlainSerializer());
        }
        return fastJsonConfig;
    }
}
