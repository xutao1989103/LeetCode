package abstractaAndInterface;

/**
 * Created by Administrator on 2014/11/24.
 */
public class AlarmDoor extends Door implements IalarmDoor {
    @Override
    void open() {
        System.out.println("open");
    }

    @Override
    void close() {
        System.out.println("close");
    }

    @Override
    public void alarm() {
        System.out.println("alarm");
    }
    AlarmDoor(int height,int weight){
        this.height=height;
        this.wieght=weight;
    }
}
