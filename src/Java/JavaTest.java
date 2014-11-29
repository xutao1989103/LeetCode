package Java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 431 on 2014/11/29.
 */
public class JavaTest {
    public static void main(String[] args){
        test();
    }
    public static void test(){
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list.toString());
        changeList(list);
        System.out.println(list.toString());
        int aa=1000;
        System.out.println(aa);
        String string="string";
        System.out.println(change(string));
    }
    public static String change(String input){
        input=input+="ss";
        return input;
    }
    public static List<Integer> changeList(List<Integer> list){
        List<Integer> result=new ArrayList<Integer>();
        list.remove(1);
        list.add(5);
        return result;
    }
}
