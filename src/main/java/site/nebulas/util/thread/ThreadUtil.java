package site.nebulas.util.thread;

/**
 * Created by Administrator on 2016/12/17.
 */
public class ThreadUtil {
    public static void main(String[] args) {
        Thread thread = new ThreadDemo();
        thread.setName("nebula");
        thread.start();

        Thread runable = new Thread(new RunnableDemo(),"run");
        runable.start();
    }
}
