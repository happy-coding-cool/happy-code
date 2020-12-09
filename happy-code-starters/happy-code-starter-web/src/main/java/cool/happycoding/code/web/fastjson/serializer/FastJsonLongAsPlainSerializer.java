package cool.happycoding.code.web.fastjson.serializer;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * description
 *
 * @author lanlanhappy 2020/12/09 10:18 下午
 */
public class FastJsonLongAsPlainSerializer implements ObjectSerializer {

    /**
     * 排除 分页参数的序列化
     */
    private final Set<String> excludeFieldNames = Sets.newHashSet("current", "pages", "size");

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
            throws IOException {

        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }

        // 超过对long类型强制转化成string
        if (!excludeFieldNames.contains(StrUtil.toString(fieldName))){
            serializer.getWriter().writeString(Long.toString((Long) object));
        }else{
            serializer.getWriter().writeLong((Long)object);
        }
    }
}
