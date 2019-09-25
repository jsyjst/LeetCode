package medium._384;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/25
 *     desc   : 打乱一个没有重复元素的数组。
 * </pre>
 */
public class Solution {
    /**
     * // 以数字集合 1, 2 和 3 初始化数组。
     * int[] nums = {1,2,3};
     * Solution solution = new Solution(nums);
     *
     * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     * solution.shuffle();
     *
     * // 重设数组到它的初始状态[1,2,3]。
     * solution.reset();
     *
     * // 随机返回数组[1,2,3]打乱后的结果。
     * solution.shuffle();
     */
    private int[] reset;
    private int[] array;
    private List<Integer> box;
    private Random random ;
    public Solution(int[] nums) {
        reset = nums;
        array = nums.clone();
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return reset;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        //暴力法
//        box = getCopyOfArray(array);
//        for (int i = 0; i < array.length; i++) {
//            int removeIndex = random.nextInt(box.size());
//            array[i] = box.get(removeIndex);
//            box.remove(removeIndex);
//        }
//        return array;
        for (int i = 0; i < array.length; i++) {
            swap(array,i,getRandom(i,array.length));
        }
        return array;

    }

    private int getRandom(int min,int max){
        return random.nextInt(max-min)+min;
    }

    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private List<Integer> getCopyOfArray(int[] nums){
        List<Integer> res =new ArrayList<>();
        for (int anArray : nums) {
            res.add(anArray);
        }
        return res;
    }


//    //全排列方法，超出时间限制
//    private void helper(List<List<Integer>> res,List<Integer> subRes,boolean[] visit){
//        if(subRes.size() == reset.length){
//            res.add(new ArrayList<>(subRes));
//            return;
//        }
//        for (int i = 0; i < reset.length; i++) {
//            if(visit[i]) return;
//            visit[i]  = true;
//            subRes.add(reset[i]);
//            helper(res,subRes,visit);
//            visit[i] = false;
//            subRes.remove(subRes.size()-1);
//        }
//    }
}
