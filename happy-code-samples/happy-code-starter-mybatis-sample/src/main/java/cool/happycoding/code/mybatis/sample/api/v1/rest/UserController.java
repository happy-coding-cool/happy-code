package cool.happycoding.code.mybatis.sample.api.v1.rest;

import cool.happycoding.code.base.result.BaseResult;
import cool.happycoding.code.base.result.ListResult;
import cool.happycoding.code.mybatis.sample.api.v1.form.UserForm;
import cool.happycoding.code.mybatis.sample.app.service.IUserService;
import cool.happycoding.code.mybatis.sample.domain.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 2:28 下午
 */
@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @ApiOperation(value = "根据Id获取User", notes = "获取User")
    @GetMapping(value = "/{id}")
    public BaseResult<UserDTO> get(@PathVariable String id) {
        log.debug("get with id:{}", id);
        return BaseResult.success(userService.get(id));
    }

    @ApiOperation(value = "根据条件搜索User", notes = "获取user列表")
    @PostMapping(value = "/list")
    public ListResult<UserDTO> list(@RequestBody UserForm userForm) {
        log.debug("list with userForm:{}", userForm);
        return ListResult.success(userService.list(userForm));
    }
}
