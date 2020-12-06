package cool.happycoding.code.base.pojo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ReflectUtil;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 3:14 下午
 */
public interface H extends Serializable {

    /**
     * 对象转换
     * @param source
     * @param tClass
     * @param copyOptions
     * @param <T>
     * @return
     */
    default <T> T copy(Object source, Class<T> tClass, CopyOptions copyOptions){
        T target = ReflectUtil.newInstanceIfPossible(tClass);
        BeanUtil.copyProperties(source, target, copyOptions);
        return target;
    }
    /**
     * 对象转换
     * @param source
     * @param clazz
     * @param <D>
     * @param <S>
     * @return
     */
    default  <D, S> D copy(S source, Class<D> clazz) {
        return copy(source, clazz, CopyOptions.create());
    }

    /**
     * list 转换
     * @param sourceList
     * @param clazz
     * @param <D>
     * @param <S>
     * @return
     */
    default <D, S> List<D> copy(List<S> sourceList, Class<D> clazz){
        return sourceList.parallelStream()
                .map(e->copy(e, clazz))
                .collect(Collectors.toList());
    }
}
