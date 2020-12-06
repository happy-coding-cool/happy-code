package cool.happycoding.code.mybatis.sample.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.happycoding.code.mybatis.sample.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * description
 *
 * @author lanlanhappy 2020/12/06 2:26 下午
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
