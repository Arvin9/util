package site.nebulas.util.thread;

/**
 * Created by Administrator on 2016/12/18.
 */
public class RunnableDemo implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName()+"start");
        int count = 0;
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"count:"+count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"end");
    }

    public static void main(String[] args) {
        Thread runable = new Thread(new RunnableDemo(),"run");
        runable.start();
    }
}
