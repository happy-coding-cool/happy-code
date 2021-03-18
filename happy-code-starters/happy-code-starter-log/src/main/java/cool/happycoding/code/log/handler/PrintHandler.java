package cool.happycoding.code.log.handler;

import cn.hutool.core.util.StrUtil;

/**
 * description
 *
 * @author lanlanhappy 2021/03/18 9:59 上午
 */
public interface PrintHandler {

    /**
     * 打印
     */
    void print();

    /**
     * 判断 contentType
     * @param contentType
     * @param expectType
     * @return
     */
    default boolean checkContentType(String contentType, String expectType) {
        return contentType != null && StrUtil.startWithIgnoreCase(contentType, expectType);
    }
}
