package cool.happycoding.code.user.wrapper;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * description
 *
 * @author lanlanhappy 2020/12/04 9:56 下午
 */
public class HttpServletRequestHeaderWrapper extends HttpServletRequestWrapper {

    private final Map<String, String> customerHeaders;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public HttpServletRequestHeaderWrapper(HttpServletRequest request) {
        super(request);
        this.customerHeaders = Maps.newHashMap();
    }

    public void addHeader(String key, String val){
        customerHeaders.put(key, val);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        Enumeration<String> headerNames = super.getHeaderNames();
        Set<String> headerNamesSet = customerHeaders.keySet();
        CollectionUtil.addAll(headerNamesSet, headerNames);
        return CollectionUtil.asEnumeration(headerNamesSet.iterator());
    }

    @Override
    public String getHeader(String name) {
        if (StrUtil.isNotBlank(customerHeaders.get(name))){
            return customerHeaders.get(name);
        }
        return super.getHeader(name);
    }

}
