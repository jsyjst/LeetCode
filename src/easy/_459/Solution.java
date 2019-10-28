package easy._459;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/28
 *     desc   : 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * </pre>
 */
public class Solution {
    /**
     * 输入: "abab"
     * 输出: True
     * 解释: 可由子字符串 "ab" 重复两次构成。
     */

    //从字符串总个数的公因数开始计算
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len<=1) return false;
        //首先找出公因数
        List<Integer> nums= new ArrayList<>();
        nums.add(1);
        for (int i = 2; i <= Math.sqrt(len); i++) {
            if(len%i==0) {
                nums.add(i);
                nums.add(len/i);
            }
        }
        boolean res;
        for (int num : nums) {
            String temp = s.substring(0, num);
            res = true;
            for (int j = num; j < len; j+=num) {
                if(!temp.equals(s.substring(j,j+num))) {
                    res = false;
                    break;
                }
            }
            if(res) return true;
        }
        return false;
    }
}
