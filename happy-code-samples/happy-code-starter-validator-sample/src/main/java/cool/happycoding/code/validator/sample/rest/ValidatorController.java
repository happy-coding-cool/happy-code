package cool.happycoding.code.validator.sample.rest;

import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.validator.ValidatorEnhance;
import cool.happycoding.code.validator.sample.bean.ValidateBean;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ValidatorController {

    private final ValidatorEnhance validatorEnhance;

    @PostMapping("val")
    public BaseResult<ValidateBean> validate(@Valid @RequestBody ValidateBean validateBean){
        return BaseResult.success(validateBean);
    }

    @PostMapping("val-tool")
    public BaseResult<ValidateBean> validateTool(@RequestBody ValidateBean validateBean){
        validatorEnhance.valid(validateBean);
        return BaseResult.success(validateBean);
    }
}
