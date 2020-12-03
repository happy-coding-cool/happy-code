package cool.happycoding.validator.sample.rest;

import cool.happycoding.base.result.BaseResult;
import cool.happycoding.validator.sample.bean.ValidateBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * description
 *
 * @author lanlanhappy 2020/12/01 10:22 下午
 */
@RestController
@RequestMapping("validate")
public class ValidatorController {

    @PostMapping("val")
    public BaseResult<ValidateBean> validate(@Valid @RequestBody ValidateBean validateBean){
        return BaseResult.success(validateBean);
    }
}