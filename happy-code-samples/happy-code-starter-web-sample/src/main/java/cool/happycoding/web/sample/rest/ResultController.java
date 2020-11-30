package cool.happycoding.web.sample.rest;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import cool.happycoding.base.result.BaseResult;
import cool.happycoding.base.result.ListResult;
import cool.happycoding.base.result.PageResult;
import cool.happycoding.web.sample.bean.SampleWeb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:36 下午
 */
@RestController
@RequestMapping("result")
public class ResultController {


    @GetMapping("get")
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

    @GetMapping("list")
    public ListResult<SampleWeb> list(){
        return ListResult.success(listData());
    }

    @GetMapping("page")
    public PageResult<SampleWeb> page(){
        return PageResult.success(1, 1, 3, listData());
    }

    private List<SampleWeb> listData(){
        List<SampleWeb> lists = Lists.newArrayList();
        SampleWeb s1 = SampleWeb.builder().id("1").userName("北京")
                .addr("Beijing").age(2000)
                .salary(BigDecimal.valueOf(45678L))
                .birth(DateUtil.parse("1180-10-21"))
                .build();
        SampleWeb s2 = SampleWeb.builder().id("2").userName("上海")
                .addr("Shanghai").age(1000)
                .salary(BigDecimal.valueOf(45678L))
                .birth(DateUtil.parse("1280-10-21"))
                .build();
        SampleWeb s3 = SampleWeb.builder().id("3").addr("深圳").age(40)
                .birth(DateUtil.parse("1980-10-21"))
                .salary(BigDecimal.valueOf(1234567L))
                .userName("深圳")
                .build();
        lists.add(s1);
        lists.add(s2);
        lists.add(s3);
        return lists;
    }

}
