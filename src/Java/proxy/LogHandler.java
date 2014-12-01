package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2014/11/24.
 */
public class LogHandler implements InvocationHandler {
    private Object dele;

    public LogHandler(Object obj){
       this.dele=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result=method.invoke(dele,args);
        after();
        return  result;
    }
    private void doBefore() {
        System.out.println("before....");
    }
    private void after() {
        System.out.println("after....");
    }
}
