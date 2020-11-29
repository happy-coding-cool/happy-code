package cool.happycoding.web.sample.rest;

import cn.hutool.core.date.DateUtil;
import cool.happycoding.base.result.BaseResult;
import cool.happycoding.web.sample.bean.SampleWeb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:36 下午
 */
@RestController
public class ResultController {


    @GetMapping
    public BaseResult<SampleWeb> get(String id){
        return BaseResult.success(SampleWeb
                .builder()
                .id(id)
                .addr("深圳")
                .age(40)
                .birth(DateUtil.parse("1980-10-21"))
                .salary(BigDecimal.valueOf(1234567L))
                .userName("深圳")
                .build());
    }

}
