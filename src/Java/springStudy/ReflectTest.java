package springStudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2014/10/31.
 */
public class ReflectTest {
    public static Car initByDefaultConst()throws Throwable{
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("springStudy.Car");
        loader.getParent();
        Constructor cons=clazz.getDeclaredConstructor(String.class,String.class,int.class);
        Car car=(Car)cons.newInstance("roslas","red",100);
        Method setBrand=clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"bmw");
        return car;
    }

    public static void main(String[] args)throws Throwable{
        Car car=initByDefaultConst();
        car.introduce();
    }
}
