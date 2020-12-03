package cool.happycoding.code.web.sample.rest;

import cn.hutool.core.util.StrUtil;
import cool.happycoding.code.base.result.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cool.happycoding.code.base.util.HappyCodeUtil.check;
import static cool.happycoding.code.web.sample.WebStatus.PARAM_ILLEGAL;

/**
 * description
 *
 * @author lanlanhappy 2020/11/30 9:16 下午
 */
@RestController
@RequestMapping("exception")
public class ExceptionController {


    @GetMapping("biz")
    public BaseResult<?> bizException(String id){
        check(StrUtil.equalsAnyIgnoreCase(id, "999"), PARAM_ILLEGAL);
        return BaseResult.success(id);
    }
}
