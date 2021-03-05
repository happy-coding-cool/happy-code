package cool.happycoding.code.base.result;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 4:55 下午
 */
public class ListResult<T> extends BaseResult<List<T>> {

    public ListResult(List<T> data){
        super();
        setData(data);
    }

    public ListResult(){
        this(Lists.newArrayList());
    }

    public static ListResult<?> success(){
        return new ListResult<>();
    }

    public static <T> ListResult<T> success(List<T> data){
        return of(data);
    }

    public static <T> ListResult<T> of(List<T> data){
        return new ListResult<T>(data);
    }

    public static ListResult<?> failure(String errCode, String errMessage) {
        ListResult<?> listResult = new ListResult<>();
        listResult.setResultCode(errCode);
        listResult.setResultMessage(errMessage);
        return listResult;
    }

}
