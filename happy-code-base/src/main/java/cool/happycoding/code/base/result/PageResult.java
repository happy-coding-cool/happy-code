package cool.happycoding.code.base.result;

import cool.happycoding.code.base.common.HappyStatus;
import lombok.Data;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:57 下午
 */
@Data
@Deprecated
public class PageResult<T> extends BaseResult<List<T>> {

    private long current;
    private long pages;
    private long total;

    public PageResult(){
        super();
    }

    public PageResult(long current, long pages, long total, List<T> data){
        super(data);
        this.current = current;
        this.pages = pages;
        this.total = total;
    }

    public static <T> PageResult<T> success(long current, long pages, long total, List<T> data){
        return of(current, pages, total, data);
    }

    public static <T> PageResult<T> of(long current, long pages, long total, List<T> data){
        return new PageResult<>(current, pages, total, data);
    }

    public static PageResult<?> success() {
        PageResult<?> pageResult = new PageResult<>();
        pageResult.setResultCode(HappyStatus.SUCCESSFUL.getCode());
        pageResult.setResultMessage(HappyStatus.SUCCESSFUL.getMessage());
        return pageResult;
    }

    
    public static PageResult<?> failure(String errCode, String errMessage) {
        PageResult<?> pageResult = new PageResult<>();
        pageResult.setResultCode(errCode);
        pageResult.setResultMessage(errMessage);
        return pageResult;
    }


}