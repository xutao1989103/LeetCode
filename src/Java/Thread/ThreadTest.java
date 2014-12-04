package Thread;


import java.util.concurrent.Executor;

/**
 * Created by Administrator on 2014/11/21.
 */
class ThreadTest implements Executor{
    Runnable runnable=new Thread();
    @Override
    public void execute(Runnable runnable){
        runnable.run();
    }

}
