package cool.happycoding.code.user;

import cool.happycoding.code.base.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:49 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DefaultUser implements User {

    private String userId;
    private String userName;

    public static DefaultUser defaultUser(String userId, String userName) {
        DefaultUser defaultUser = new DefaultUser();
        defaultUser.setUserId(userId);
        defaultUser.setUserName(userName);
        return defaultUser;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
