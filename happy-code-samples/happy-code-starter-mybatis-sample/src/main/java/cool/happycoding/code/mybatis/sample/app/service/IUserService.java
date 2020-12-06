package cool.happycoding.code.mybatis.sample.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.happycoding.code.mybatis.sample.api.v1.form.UserForm;
import cool.happycoding.code.mybatis.sample.domain.dto.UserDTO;
import cool.happycoding.code.mybatis.sample.domain.entity.User;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 2:27 下午
 */
public interface IUserService extends IService<User> {

    /**
     * 根据Id获取User
     * @param id
     * @return
     */
    UserDTO get(String id);

    /**
     * 根据条件获取用户列表
     * @param userForm
     * @return
     */
    List<UserDTO> list(UserForm userForm);
}
