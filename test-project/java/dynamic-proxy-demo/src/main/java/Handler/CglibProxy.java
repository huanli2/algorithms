package Handler;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by lih on 2017/4/1.
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        if ("getName".equals(method.getName()) || "getAge".equals(method.getName())) {
            System.out.println("++++before " + method.getName() + "+++++ by invoke");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("----after " + method.getName() + "+++++ by invoke");

            return result;
        } else {
            Object result = methodProxy.invokeSuper(o, objects);

            return result;
        }
    }
}
