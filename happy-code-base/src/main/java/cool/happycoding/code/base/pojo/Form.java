package cool.happycoding.code.base.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * <p>
 *     请求参数基类
 * </p>
 *
 * @author lanlanhappy 2020/10/04 9:24 上午
 */
@Data
@ToString
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

    /**
     * form list 转换 entity list
     * @param formList
     * @param clazz
     * @param <E>
     * @param <F>
     * @return
     */
    public <E, F> List<E> toEntity(List<F> formList, Class<E> clazz){
        return copy(formList, clazz);
    }

}
