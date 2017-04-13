package Handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lih on 2017/3/30.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object o) {
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if ("getName".equals(method.getName()) || "getAge".equals(method.getName())) {
            System.out.println("++++before " + method.getName() + "+++++ by invoke");
            Object result = method.invoke(target, args);
            System.out.println("----after " + method.getName() + "+++++ by invoke");

            return result;
        } else {
            Object result = method.invoke(target, args);

            return result;
        }
    }
}
