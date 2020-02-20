package 面试算法题.cvte.笔试.生产者消费者;

import java.util.LinkedList;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/01/06
 *     desc   : 生产者和消费者
 * </pre>
 */
public class SafeQueue {
    private LinkedList<Value> queue;
    private int size = 10;  //大小

    public SafeQueue(){
        queue = new LinkedList<>();
    }

    private synchronized void offer(Value v) throws InterruptedException {
        if(queue.size() == size) wait();
        queue.offer(v);
        notifyAll();
    }

    private synchronized Value take() throws InterruptedException {
        if(queue.isEmpty()) wait();
        Value v = queue.remove();
        notifyAll();
        return v;
    }

}
