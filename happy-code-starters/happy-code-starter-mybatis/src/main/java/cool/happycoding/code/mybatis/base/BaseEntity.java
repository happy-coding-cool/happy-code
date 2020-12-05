package cool.happycoding.code.mybatis.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import cool.happycoding.code.base.pojo.Entity;
import lombok.Data;

import java.util.Date;

/**
 * description
 *
 * @author lanlanhappy 2020/12/05 1:58 下午
 */
@Data
public class BaseEntity extends Entity {

    @TableId
    private String id;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(fill = FieldFill.INSERT)
    private String createdById;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedById;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

}
