package cool.happycoding.code.base.pojo;

import lombok.Data;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 11:30 上午
 */
@Data
public class PageForm extends Form{
    /**
     * 分页查询的参数，当前页数s
     */
    private long current = 1;
    /**
     * 分页查询的参数，当前页面每页显示的数量
     */
    private long size = 10;
}
