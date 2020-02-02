package swordOffer._29数组只出现一次的的数字;

import java.util.Arrays;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/02
 *     desc   : 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * </pre>
 */
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        boolean isFirst = false;
        for(int i = 0; i < array.length; i++){
            if(i == 0){
                if(array[i] != array[i+1]) num1[0] = array[0];
            }else if(i == array.length -1){
                if(array[i] != array[i-1]) num2[0] = array[i];
            }else{
                if(array[i] != array[i-1]&&array[i]!=array[i+1]){
                    if(!isFirst){
                        isFirst = true;
                        num1[0] = array[i];
                    }else{
                        num2[0] = array[i];
                    }
                }
            }
        }
    }
}
