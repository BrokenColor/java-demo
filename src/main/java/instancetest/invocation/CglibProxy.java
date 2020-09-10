package instancetest.invocation;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 动态代理
 *
 * @Author: bc
 * @DateTime: 2020/9/10 下午8:03
 * @Description: TODO
 * <p>
 * 自定义 MethodInterceptor 并重写 intercept 方法，intercept 用于拦截增强被代理类的方法。
 * <p>
 * JDK 动态代理只能只能代理实现了接口的类，而 CGLIB 可以代理未实现任何接口的类。
 * 另外， CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，
 * 因此不能代理声明为 final 类型的类和方法。
 */
public class CglibProxy implements MethodInterceptor {

    //创建动态代理增强类
    private Enhancer enhancer = new Enhancer();

    public Object getTarget(Class<?> clazz){
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置被代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(this);
        // 创建代理类
        return enhancer.create();
    }
    /**
     * 当你使用代理对象调用方法的时候实际会调用到这个方法
     *
     * @param obj    被代理的对象（需要增强的对象）
     * @param method 被拦截的方法（需要增强的方法）
     * @param args   方法入参
     * @param proxy  用于调用原始方法
     * @return
     * @throws Throwable 异常
     *
     *  CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，因此不能代理声明为 final 类型的类和方法。
     *
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before method " + method.getName());
        //通过代理类调用父类中的方法
        Object invoke = proxy.invokeSuper(obj, args);
        System.out.println("after method " + method.getName());
        return invoke;
    }

    public static void main(String[] args) {
        /**
         * 定义一个类；
         * 自定义 MethodInterceptor 并重写 intercept 方法，intercept 用于拦截增强被代理类的方法，和 JDK 动态代理中的 invoke 方法类似；
         * 通过 Enhancer 类的 create()创建代理类；
         */
        CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        UserServiceImpl proxyImp = (UserServiceImpl)proxy.getTarget(UserServiceImpl.class);
        proxyImp.add();
    }
}
