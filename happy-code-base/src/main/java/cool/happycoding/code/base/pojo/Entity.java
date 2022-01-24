package cool.happycoding.code.base.pojo;


import lombok.Data;
import lombok.ToString;

/**
 * <p>数据库 entity 对象基础类</p>
 *
 * @author lanlanhappy 2020/12/05 1:31 下午
 */
@Data
@ToString
@Deprecated
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
}
