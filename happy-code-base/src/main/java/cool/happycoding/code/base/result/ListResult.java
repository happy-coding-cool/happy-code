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

    public static <T> ListResult<T> success(List<T> data){
        return new ListResult<T>(data);
    }

}
