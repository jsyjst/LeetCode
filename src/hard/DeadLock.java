package hard;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/10
 *     desc   : 死锁
 * </pre>
 */
public class DeadLock {
    //字符串来模拟两者笔
    private static final String Pen = "Pen";
    private static final String Pencil="Pencil";

    public static void main(String[] args){
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();//线程1开始写字
        thread2.start();//线程2开始写字
    }
    //线程1
    static class Thread1 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread1 Writing");
            while (true){
                synchronized (DeadLock.Pen){//线程1先用Pen写字
                    System.out.println("Thread1 using Pen");
                    try {
                        Thread.sleep(3000);//使用Pen后需要等一会，让Thread2有足够时间去使用Pencil
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (DeadLock.Pencil){//线程1正在使用Pencil写字
                        System.out.println("Thread1 using Pencil");
                    }
                }
            }
        }
    }


    //线程2
    static class Thread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread2 Writing");
            while (true){
                synchronized (DeadLock.Pencil){//线程2首先使用Pencil写字
                    System.out.println("Thread2 using Pencil");
                    try {
                        Thread.sleep(3000);//使用Pencil写字后，需要等一会，让线程有时间去拿Pen来写字
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (DeadLock.Pen){//线程2使用Pen来写字
                        System.out.println("Thread2 using Pen");
                    }
                }
            }
        }
    }
}
