package cool.happycoding.code.user.sample.rest;

import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.base.user.User;
import cool.happycoding.code.user.context.UserContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author lanlanhappy 2020/12/04 9:47 下午
 */
@RestController("user-context")
public class UserContextController {

    @GetMapping("defaultUser")
    public BaseResult<User> defaultUser(){
        return BaseResult.success(UserContextHolder.getUser());
    }
}
