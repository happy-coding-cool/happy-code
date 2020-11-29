package cool.happycoding.web.fastjson.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:17 下午
 */
public class FastJsonBigDecimalAsPlainSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
            throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }
        if (fieldType == BigDecimal.class){
            out.writeString(((BigDecimal)object).toPlainString());
        }
    }
}
