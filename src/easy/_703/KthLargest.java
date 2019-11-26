package easy._703;

import java.util.PriorityQueue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/26
 *     desc   :
 * </pre>
 */
public class KthLargest {
    private int k ;
    private int[] nums;
    private PriorityQueue<Integer> priorityQueue;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        //容量为k的小顶堆，从而保证堆顶为第k大的数
        priorityQueue = new PriorityQueue<>(k);
        for(int num:nums) add(num);
    }

    public int add(int val) {
        if(priorityQueue.size()<k){
            priorityQueue.add(val);
        }else if(val>priorityQueue.peek()){
            priorityQueue.remove();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
