package cool.happycoding.code.mybatis.sample.api.v1.form;

import cool.happycoding.code.mybatis.base.BaseForm;
import lombok.Data;

import java.math.BigDecimal;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 2:30 下午
 */
@Data
public class UserForm extends BaseForm {

    private String name;
    private Integer age;
    private String gender;
    private String addr;
    private BigDecimal salary;
    private String remark;
}
