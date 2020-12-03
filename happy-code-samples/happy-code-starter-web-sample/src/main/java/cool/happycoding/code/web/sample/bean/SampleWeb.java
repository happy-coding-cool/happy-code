package cool.happycoding.code.web.sample.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/11/29 5:57 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SampleWeb implements Serializable {

    private String id;
    private String userName;
    private int age;
    private String addr;
    private BigDecimal salary;
    private Date birth;

}
