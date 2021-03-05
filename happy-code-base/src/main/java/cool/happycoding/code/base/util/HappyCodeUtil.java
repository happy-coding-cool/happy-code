package cool.happycoding.code.base.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.common.ResultCode;
import cool.happycoding.code.base.exception.Assert;
import cool.happycoding.code.base.exception.BizException;
import cool.happycoding.code.base.exception.ExceptionFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author lanlanhappy 2020/11/28 6:10 下午
 */
public final class HappyCodeUtil {

    /**
     * 用于对业务条件进行判断
     * @param condition
     * @param error
     */
    public static void check(boolean condition, ResultCode error) {
        Assert.isFalse(condition, error.getCode(), error.getMessage());
    }

    /**
     * @param originalVal
     * @param defaultVal
     * @return
     */
    public static String ifBlankDefault(String originalVal, String defaultVal) {
        return StrUtil.isBlank(originalVal) ? defaultVal : originalVal;
    }


    /**
     * list 转换
     * @param sourceList
     * @param clazz
     * @param <D>
     * @param <S>
     * @return
     */
    public static  <D, S> List<D> copy(List<S> sourceList, Class<D> clazz){
        return sourceList.stream()
                .map(e-> BeanUtil.copyProperties(e, clazz))
                .collect(Collectors.toList());
    }
}
