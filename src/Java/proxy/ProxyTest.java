package proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2014/11/24.
 */
public class ProxyTest {
    public static void main(String[] args){
        HelloImpl impl=new HelloImpl();
        LogHandler handler=new LogHandler(impl);
        Hello hello=(Hello) Proxy.newProxyInstance(impl.getClass().getClassLoader(),impl.getClass().getInterfaces(),handler);
        hello.sayHello("xt");
        hello.print("tt");
    }
}
