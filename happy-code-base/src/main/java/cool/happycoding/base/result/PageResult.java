package cool.happycoding.base.result;

import lombok.Data;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:57 下午
 */
@Data
public class PageResult<T> extends BaseResult<List<T>> {

    private long current;
    private long pages;
    private long total;

    public PageResult(long current, long pages, long total, List<T> data){
        super(data);
        this.current = current;
        this.pages = pages;
        this.total = total;
    }

    public static <T> PageResult<T> success(long current, long pages, long total, List<T> data){
        return new PageResult<>(current, pages, total, data);
    }

}