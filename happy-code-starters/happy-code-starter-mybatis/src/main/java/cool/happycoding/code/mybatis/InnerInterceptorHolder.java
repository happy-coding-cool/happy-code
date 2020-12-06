package cool.happycoding.code.mybatis;

import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

/**
 * description
 *
 * @author lanlanhappy 2020/12/05 1:13 下午
 */
class InnerInterceptorHolder {

    /**
     * 分页插件
     * @param happyMybatisProperties
     * @return
     */
    public static PaginationInnerInterceptor paginationInnerInterceptor(HappyMybatisProperties happyMybatisProperties) {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(happyMybatisProperties.isOverflow());
        // 设置最大单页限制数量
        paginationInterceptor.setMaxLimit(happyMybatisProperties.getLimit());
        return paginationInterceptor;
    }

    /**
     * 阻塞插件，用于sql安全执行
     * @return
     */
    public static BlockAttackInnerInterceptor blockAttackInnerInterceptor(){
        return new BlockAttackInnerInterceptor();
    }
}
