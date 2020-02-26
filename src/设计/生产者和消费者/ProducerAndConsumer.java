package 设计.生产者和消费者;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/26
 *
 *     desc   :
 * </pre>
 */
public class ProducerAndConsumer {

    //缓存池
    private LinkedList<Integer> queue = new LinkedList<>();
    //缓存池大小
    private int maxSize = 10;

    //生产者
    class Producer extends Thread{
        @Override
        public void run(){
            //生产者
            producer();
        }

        private void producer(){
            while (true){
                synchronized (queue){
                    while (queue.size() == maxSize){
                        System.out.println("当前队列已满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    System.out.println("生产者生产了了一个产品，当前队列长度为："+queue.size());
                    queue.notify();
                    //睡眠0.5s
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    //消费者
    class Consumer extends Thread{
        @Override
        public void run(){
            //消费者
            consumer();
        }

        private void consumer(){
            while (true){
                synchronized (queue){
                    while (queue.size() == 0){
                        System.out.println("当前队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.remove();
                    System.out.println("消费者消费了一个产品，当前队列长度为："+queue.size());
                    queue.notify();
                    //睡眠0.5s
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        ProducerAndConsumer pAndC = new ProducerAndConsumer();
        Producer producer = pAndC.new Producer();
        Consumer consumer = pAndC.new Consumer();
        producer.start();
        consumer.start();
    }
}
