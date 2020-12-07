package cool.happycoding.code.mybatis.sample.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.happycoding.code.base.util.HappyCodeUtil;
import cool.happycoding.code.mybatis.sample.api.v1.form.UserForm;
import cool.happycoding.code.mybatis.sample.app.service.IUserService;
import cool.happycoding.code.mybatis.sample.domain.dto.UserDTO;
import cool.happycoding.code.mybatis.sample.domain.entity.User;
import cool.happycoding.code.mybatis.sample.domain.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 2:27 下午
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public UserDTO get(String id) {
        return this.getById(id).toDTO(UserDTO.class);
    }

    @Override
    public List<UserDTO> list(UserForm userForm) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> users = this.list(queryWrapper);
        return HappyCodeUtil.copy(users, UserDTO.class);
    }

    @Override
    public UserDTO save(UserForm userForm) {
        User user = userForm.toEntity(User.class);
        this.save(user);
        return user.toDTO(UserDTO.class);
    }
}
