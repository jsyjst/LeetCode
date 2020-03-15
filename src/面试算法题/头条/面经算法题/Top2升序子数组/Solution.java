package 面试算法题.头条.面经算法题.Top2升序子数组;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/03/14
 *     desc   : 找出一个数组的长度 Top2 的升序子数组，并按长度降序输出
 *              例如：
 *                  输入：[2, 1, 4, 5, 8, 3, 7, 10, 2, 5]
 *                  输出：[1, 4, 5, 8], [3, 7, 10]
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        int[] nums = new int[]{2, 1, 4, 5, 8, 3, 7, 10, 2, 5};
        for(List<Integer> numList: getTop2(nums)){
            System.out.println(numList);
        }
    }

    public static List<List<Integer>> getTop2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return res;
        int firstMax = 1;
        int secondMax = 1;
        int firstLeft = 0, firstRight = 0;
        int secondLeft = 0, secondRight = 0;
        int i = 0;
        int count;
        while (i < len - 1){
            count = 1;
            int left = i;
            while (i < len - 1 && nums[i+1] > nums[i]) {
                i++;
                count++;
            }
            if(count > firstMax){
                secondMax = firstMax;
                secondLeft = firstLeft;
                secondRight = firstRight;
                firstMax = count;
                firstLeft = left;
                firstRight = i;
            }else if(count > secondMax){
                secondMax = count;
                secondLeft = left;
                secondRight = i;
            }
            i++;
        }
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for(int j = firstLeft; j <= firstRight;j++) firstList.add(nums[j]);
        for(int j = secondLeft; j <= secondRight;j++) secondList.add(nums[j]);
        res.add(firstList);
        res.add(secondList);
        return res;
    }
}
