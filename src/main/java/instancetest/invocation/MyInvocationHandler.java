package instancetest.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 *
 * @Author: bc
 * @DateTime: 2020/9/10 下午7:35
 * @Description: TODO
 * <p>
 * 要实现动态代理的话，还必须需要实现InvocationHandler 来自定义处理逻辑。
 * 当我们的动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现InvocationHandler 接口类的 invoke 方法来调用。
 * <p>
 * JDK动态代理和Cglib动态代理的区别 JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。
 * 如果想代理没有实现接口的类，就可以使用CGLIB实现。
 *
 * 就二者的效率来说，大部分情况都是 JDK 动态代理更优秀，随着 JDK 版本的升级，这个优势更加明显.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  动态生成的代理类
     * @param method 与代理类对象调用的方法相对应
     * @param args   当前 method 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method " + method.getName());
        Object invoke = method.invoke(proxy, args);
        System.out.println("after method " + method.getName());
        return invoke;
    }

    public Object getTarget() {
        //loader :类加载器，用于加载代理对象。
        //interfaces : 被代理类实现的一些接口；
        //h : 实现了 InvocationHandler 接口的对象；
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    public static void main(String[] args) {
        /**
         * 1.定义一个接口及其实现类；
         * 2.自定义 InvocationHandler 并重写invoke方法，
         *  在 invoke 方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
         * 3.通过 Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) 方法创建代理对象；
         */
        UserService service = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(service);
        UserService target = (UserService) myInvocationHandler.getTarget();
        target.add();
    }
}
