package pri.arnold.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Arnold
 * @Date: 2022/6/30 20:12
 */
public interface Human {

    String getBelief();

    void eat(String food);
}

class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I Believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class ProxyFactory {

    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}

class ProxyTest {

    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("面条");
    }
}
