package cool.happycoding.code.mq.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/12/13 12:29 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderReply implements Serializable {
    private Date replyTime;
    private Order order;
}
