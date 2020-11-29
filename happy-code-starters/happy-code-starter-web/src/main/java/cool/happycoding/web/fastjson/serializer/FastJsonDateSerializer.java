package cool.happycoding.web.fastjson.serializer;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:10 下午
 */
public class FastJsonDateSerializer implements ObjectSerializer {

    private final String dateFormat;

    public FastJsonDateSerializer(String dateFormat){
        this.dateFormat = dateFormat;
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
            throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }

        if (fieldType == Date.class){
            out.writeString(DateUtil.format((Date)object, dateFormat));
        }
    }
}
