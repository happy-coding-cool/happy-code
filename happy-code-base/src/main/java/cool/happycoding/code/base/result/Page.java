package cool.happycoding.code.base.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2021/11/05 1:24 下午
 */
@Data
public class Page<T> implements Serializable {

    private Integer pageSize;
    private Integer pageNum;
    private Integer pages;
    private Integer total;
    private List<T> page;

    public static <T> Page<T> of(Integer pageSize, Integer pageNum, Integer total, List<T> data){
        Page<T> page = new Page<>();
        page.setPage(data);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setTotal(total);
        return page;
    }
}
