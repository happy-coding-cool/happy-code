package cool.happycoding.code.user.context;

import cool.happycoding.code.base.context.ContextHolderStrategy;
import cool.happycoding.code.base.context.ThreadLocalContextHolderStrategy;
import cool.happycoding.code.base.user.User;

/**
 * description
 *
 * @author lanlanhappy 2020/12/03 9:14 下午
 */
public class UserContextHolder {

    private static volatile ContextHolderStrategy<User> context
            = new ThreadLocalContextHolderStrategy<>();

    void setContext(ContextHolderStrategy<User> context){
        UserContextHolder.context = context;
    }

    static void setUser(User user){
        context.setContext(user);
    }

    public static User getUser(){
        return context.getContext();
    }

    public static void clear(){
        context.clearContext();
    }

}
