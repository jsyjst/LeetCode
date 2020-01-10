package swordOffer._25把数组排成最小的数;

import java.util.Arrays;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/01/10
 *     desc   : 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *     例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * </pre>
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        if(len == 0) return "";
        String[] numStrings = new String[len];
        for(int i = 0; i < len; i++){
            numStrings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numStrings,(s1, s2)->{
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return c1.compareTo(c2);
        });
        StringBuilder resBuilder = new StringBuilder();
        for(String s: numStrings){
            resBuilder.append(s);
        }
        return resBuilder.toString();
    }
}
