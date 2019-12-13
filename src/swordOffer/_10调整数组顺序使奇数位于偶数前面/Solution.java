package swordOffer._10调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/13
 *     desc   :
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void reOrderArray(int [] array) {
        int[] nums = Arrays.copyOf(array,array.length);
        int i = 0;
        for(int num:nums){
            if(num%2!=0){
                array[i++] = num;
            }
        }
        for(int num:nums){
            if(num%2==0) array[i++] = num;
        }
    }

    //插入排序

    public static void reOrderArrayOther(int [] array) {
        for (int i = 1; i < array.length; i++) {
            //单数
            if(array[i] % 2 != 0){
                int val = array[i];
                int cur = i;
                while (cur >0 && array[cur - 1] % 2 == 0){
                    array[cur] = array[cur-1];
                    cur--;
                }
                array[cur] = val;
            }
        }
    }
}
