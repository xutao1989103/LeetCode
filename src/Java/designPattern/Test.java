package designPattern;

import designPattern.flyweight.IreportManager;
import designPattern.flyweight.ReportManagerFactory;
import designPattern.singleton.Singleton;

/**
 * Created by Administrator on 2014/11/12.
 */
public class Test {
    public static void main(String[] args){
        Test test=new Test();
        test.flyweightTest();
    }

    public void singletonTest(){
        System.out.println("------------------------------------------");
        Singleton singleton=Singleton.getInstence();
        System.out.println(singleton.getName());
        Singleton singleton1=Singleton.getInstence();
        System.out.println(singleton1.getName());
    }
    public void flyweightTest(){
        System.out.println("------------------------------------------");
        ReportManagerFactory reportManagerFactory=new ReportManagerFactory();
        IreportManager rm=reportManagerFactory.getFinaceReportManager("a");
        System.out.println(rm.getReport());
        IreportManager rm1=reportManagerFactory.getFinaceReportManager("b");
        System.out.println(rm1.getReport());
        IreportManager rm2=reportManagerFactory.getBusinessReportManager("a");
        System.out.println(rm2.getReport());
    }
}
