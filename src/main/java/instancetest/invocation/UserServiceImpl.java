package instancetest.invocation;

/**
 * 被代理的类
 *
 * @Author: bc
 * @DateTime: 2020/9/10 下午7:34
 * @Description: TODO
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("--------------------add----------------------");
    }
}
