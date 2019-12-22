package swordOffer._21数组中出现次数超过一半的数字;

import java.util.Arrays;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/22
 *     desc   : 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *     由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * </pre>
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        Arrays.sort(array);
        int len = (array.length-1)/2;
        if(array[len] == array[len+1]) return array[len];
        return 0;
    }
}
