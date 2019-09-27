package medium._390;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/27
 *     desc   : 给定一个从1 到 n 排序的整数列表。
 * 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 * 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 * 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 返回长度为 n 的列表中，最后剩下的数字。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * n = 9,
     * 1 2 3 4 5 6 7 8 9
     * 2 4 6 8
     * 2 6
     * 6
     *
     * 输出:
     * 6
     */

    //未通过，超出时间限制
    public int lastRemaining(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            nums.add(i);
        }
        int i =0;
        while (nums.size()>1){
            i = 0;
            while (nums.size()>1&&i<nums.size()){
                System.out.println(nums.get(i));
                nums.remove(i++);
            }
            i = nums.size()-1;
            while (nums.size()>1&&i>=0){
                nums.remove(i);
                i = i-2;
            }
        }
        return nums.get(0);
    }


    public int lastRemainingSuccess(int n) {
        int len = n;
        int start = 1;
        int step = 1;
        boolean isLeft = true;
        while (len > 1){
            if(isLeft){
                start = start + step;
            }else {
                start = len%2 == 0?start:start+step;
            }
            len/=2;
            step*=2;
            isLeft =!isLeft;
        }
        return start;
    }
}
