package cool.happycoding.code.mybatis.base;

import cool.happycoding.code.base.pojo.DTO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/12/05 1:59 下午
 */
@Data
@ToString
public class BaseDTO extends DTO {

    private String id;
    private String createdBy;
    private String createdById;
    private Date createdTime;
    private String updatedBy;
    private String updatedById;
    private Date updatedTime;
}
