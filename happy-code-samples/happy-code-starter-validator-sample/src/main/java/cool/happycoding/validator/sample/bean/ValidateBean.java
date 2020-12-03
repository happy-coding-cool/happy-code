package cool.happycoding.validator.sample.bean;

import cool.happycoding.validator.annotation.Chinese;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * description
 *
 * @author lanlanhappy 2020/12/01 10:24 下午
 */
@Data
public class ValidateBean implements Serializable {

    @Chinese
    @Length(min = 2, max = 4)
    private String name;
    @NotBlank
    private String addr;
    @Email
    private String mail;
    private int age;
}
