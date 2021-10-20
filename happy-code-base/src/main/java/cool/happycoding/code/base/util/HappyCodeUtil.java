package cool.happycoding.code.base.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.common.ResultCode;
import cool.happycoding.code.base.exception.Assert;
import cool.happycoding.code.base.exception.BizException;
import cool.happycoding.code.base.exception.ExceptionFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author lanlanhappy 2020/11/28 6:10 下午
 */
public final class HappyCodeUtil {

    /**
     * 用于对业务条件进行判断
     * @param condition 条件
     * @param error 错误码定义
     */
    public static void check(boolean condition, ResultCode error) {
        Assert.isTrue(condition, error.getCode(), error.getMessage());
    }

    /**
     * @param originalVal 原值
     * @param defaultVal 默认值
     * @return string
     */
    public static String ifBlankDefault(String originalVal, String defaultVal) {
        return StrUtil.blankToDefault(originalVal, defaultVal);
    }


    /**
     * list 转换
     * @param sourceList 原数据列表
     * @param clazz 转换的数据类型
     * @param <D> 泛型
     * @param <S> 泛型
     * @return 返回转换后的列表
     */
    public static  <D, S> List<D> copy(List<S> sourceList, Class<D> clazz){
        return sourceList.stream()
                .map(e-> BeanUtil.copyProperties(e, clazz))
                .collect(Collectors.toList());
    }


    public static <E> List<E> nullToEmpty(List<E> list){
        return CollUtil.isEmpty(list) ? Collections.emptyList() : list;
    }

    public static <E> Set<E> nullToEmpty(Set<E> set){
        return CollUtil.isEmpty(set) ? Collections.emptySet() : set;
    }

    public static <K,V> Map<K,V> nullToEmpty(Map<K,V> map){
        return CollUtil.isEmpty(map) ? Collections.emptyMap() : map;
    }


}
