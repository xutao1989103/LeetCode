package proxy;

/**
 * Created by Administrator on 2014/11/24.
 */
public class HelloImpl implements Hello {
    @Override
    public void sayHello(String to) {
        System.out.println("hello "+to);
    }

    @Override
    public void print(String p) {
        System.out.println("print "+p);
    }
}
