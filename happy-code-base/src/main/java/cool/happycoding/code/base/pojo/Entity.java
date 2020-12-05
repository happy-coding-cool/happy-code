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
public class Entity implements E {
    private String id;
}
