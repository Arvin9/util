package site.nebulas.util.thread;

/**
 * Created by Administrator on 2016/12/18.
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println(getName()+"start");
        int count = 0;
        for (int i=0;i<100;i++){
            System.out.println(getName()+"count:"+count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName()+"end");
    }

    public static void main(String[] args) {
        Thread thread = new ThreadDemo();
        thread.setName("nebula");
        thread.start();
    }
}
