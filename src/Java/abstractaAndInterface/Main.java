package abstractaAndInterface;

/**
 * Created by Administrator on 2014/11/24.
 */
public class Main {
    public static void main(String[] args){
        AlarmDoor alarmDoor=new AlarmDoor(11,11);
        alarmDoor.open();
        alarmDoor.alarm();
        alarmDoor.close();

    }
}
