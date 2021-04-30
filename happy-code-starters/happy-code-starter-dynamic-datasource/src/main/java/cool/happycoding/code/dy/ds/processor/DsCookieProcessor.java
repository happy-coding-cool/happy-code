package cool.happycoding.code.dy.ds.processor;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.processor.DsProcessor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

/**
 * <p>
 *     通用数据源处理器
 * </p>
 *
 * @author lanlanhappy 2021/04/30 10:34 上午
 */
public class DsCookieProcessor extends DsProcessor {

    private static final String COOKIE_PREFIX = "#cookie";

    @Override
    public boolean matches(String dsKey) {
        return StrUtil.startWith(dsKey, COOKIE_PREFIX);
    }

    @Override
    public String doDetermineDatasource(MethodInvocation methodInvocation, String dsKey) {
        if (RequestContextHolder.getRequestAttributes() != null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String cookieKey = dsKey.substring(8);
            Optional<Cookie> dsCookie = Arrays.stream(request.getCookies())
                    .filter(cookie -> StrUtil.equalsAnyIgnoreCase(cookie.getName(), cookieKey))
                    .findFirst();
            return dsCookie.map(Cookie::getValue).orElse(null);
        }
        return null;
    }
}
