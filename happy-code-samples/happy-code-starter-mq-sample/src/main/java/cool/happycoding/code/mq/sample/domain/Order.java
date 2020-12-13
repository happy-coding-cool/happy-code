package cool.happycoding.code.mq.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 11:44 上午
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private String orderId;
    private String orderName;
    private Date   orderDate;

}
