package swordOffer._22最小的k个数;

import java.util.*;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/25
 *     desc   : 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *     思路：优先级队列实现
 * </pre>
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> resList = new ArrayList<>();
        if(input.length == 0 || k <= 0 || input.length < k) return resList;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)-> o2-o1);
        for(int num : input){
            if(queue.size() == k){
                if(queue.peek() > num){
                    queue.poll();
                    queue.add(num);
                }
            }else {
                queue.add(num);
            }
        }
        resList.addAll(queue);
        return resList;


    }
}
