package cool.happycoding.code.base.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 *     请求参数基类
 * </p>
 *
 * @author lanlanhappy 2020/10/04 9:24 上午
 */
@Data
@ToString
@Deprecated
public class Form implements F {

    /**
     * form 转换 entity
     * @param clazz
     * @param <E>
     * @return
     */
    public <E> E toEntity(Class<E> clazz) {
        return copy(this, clazz);
    }

}
