package cool.happycoding.code.base.pojo;


import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * <p>数据库 entity 对象基础类</p>
 *
 * @author lanlanhappy 2020/12/05 1:31 下午
 */
@Data
@ToString
public class Entity implements E {

    /**
     * entity 转换 DTO
     * @param clazz
     * @param <D>
     * @return
     */
    public <D> D toDTO(Class<D> clazz) {
        return copy(this, clazz);
    }

    /**
     * entity list 转换 DTO list
     * @param entityList
     * @param clazz
     * @param <D>
     * @param <E>
     * @return
     */
    public <D, E> List<D> toDTO(List<E> entityList, Class<D> clazz){
        return copy(entityList, clazz);
    }
}
