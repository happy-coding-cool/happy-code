package cool.happycoding.code.base.pojo;

/**
 * description
 *
 * @author lanlanhappy 2022/01/24 9:20 下午
 */
public class PageReq extends Req{
    /**
     * 分页查询的参数，当前页数s
     */
    private int current = 1;
    /**
     * 分页查询的参数，当前页面每页显示的数量
     */
    private int size = 10;
}
