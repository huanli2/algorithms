import Handler.CglibProxy;
import Handler.MyInvocationHandler;
import Service.Impl.UserServiceImpl;
import Service.UserService;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by lih on 2017/3/30.
 *
 * source:
 *   https://yq.aliyun.com/articles/71337?utm_campaign=wenzhang&utm_medium=article&utm_source=QQ-qun&2017329&utm_content=m_15243
 *
 *   AOP的拦截功能是由java中的动态代理来实现的。说白了，就是在目标类的基础上增加切面逻辑，
 *   生成增强的目标类（该切面逻辑或者在目标类函数执行之前，或者目标类函数执行之后，或者在目标类函数抛出异常时候执行。
 *   不同的切入时机对应不同的Interceptor的种类，如BeforeAdviseInterceptor，AfterAdviseInterceptor以及ThrowsAdvis
 */
public class Application {

    public static void main(String[] args) {

        jdkReflectionDemo();

        cglibProxyDemo();
    }

    private static void jdkReflectionDemo() {
        System.out.println("*****************jdk reflect demo test******************");

        UserService userService = new UserServiceImpl();
        InvocationHandler handler = new MyInvocationHandler(userService);
        Class<?> userClass = userService.getClass();
        UserService proxy = (UserService) Proxy.newProxyInstance(
                userClass.getClassLoader(), userClass.getInterfaces(), handler);

        System.out.println(proxy.getName(1));
        System.out.println(proxy.getAge(10));
        System.out.println(proxy.getNonAop(5));
    }

    private static void cglibProxyDemo() {
        System.out.println("***************** cglib demo ***********************");
        CglibProxy proxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(proxy);

        UserService userService = (UserService)enhancer.create();

        System.out.println(userService.getName(1));
        System.out.println(userService.getAge(10));
        System.out.println(userService.getNonAop(5));
    }
}
