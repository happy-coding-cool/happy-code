package cool.happycoding.web.exception;

import com.google.common.collect.ImmutableMap;
import cool.happycoding.base.exception.BizException;
import cool.happycoding.base.result.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * description
 *
 * @author lanlanhappy 2020/12/01 8:53 下午
 */
@Slf4j
@RestController
public class HappyErrorController extends AbstractErrorController {

    private static final String PATH = "/error";
    private final ErrorAttributes errorAttributes;

    public HappyErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = PATH)
    public BaseResult<ErrorDetail> handleError(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        Throwable throwable = errorAttributes.getError(webRequest);
        if (throwable instanceof BizException){
            throw (BizException)throwable;
        }else{
            Map<String, Object> attributes = getErrorAttributes(request, ErrorAttributeOptions.defaults());
            int status = (int) attributes.get("status");
            String error = (String) attributes.get("error");
            String path = (String) attributes.get("path");
            return ErrorDetail.build(String.valueOf(status), error, path, ImmutableMap.of("detail", error));
        }
    }


    @Override
    public String getErrorPath() {
        return PATH;
    }
}
