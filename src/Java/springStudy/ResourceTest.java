package springStudy;


import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;


/**
 * Created by Administrator on 2014/10/31.
 */
public class ResourceTest  {
    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("springStudy/beans.xml");
        Car car=context.getBean("car2",Car.class);
        car.introduce();
        Strings strings;
        ArrayList lists=Lists.newArrayList();
    }
}
