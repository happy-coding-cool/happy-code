package cool.happycoding.code.stream.mq.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 8:38 下午
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserBean implements Serializable {

    private String userId;
    private String userName;
    private Date birthday;
    private BigDecimal salary;

}
