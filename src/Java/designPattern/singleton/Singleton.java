package designPattern.singleton;

/**
 * Created by Administrator on 2014/11/5.
 */
public class Singleton {
    private String name="1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static Singleton instence;
    private Singleton(){}
    public static Singleton getInstence(){
        if(instence==null){
            instence=new Singleton();
        }
        return instence;
    }

}
