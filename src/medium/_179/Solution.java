package medium._179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/05
 *     desc   : 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *     说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [10,2]
     * 输出: 210
     *
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     */
    public String largestNumber(int[] nums) {
        if(nums.length ==0) return "";
        String[] strArr = new String[nums.length];
        //数组转化成字符串
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //compareTo方法返回值为1(升序),0，-1(降序)。
                // 返回1，则交换；返回-1则不交换。
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder res= new StringBuilder();
        for(String s:strArr) res.append(s);
        if(res.charAt(0)=='0') return "0";
        return res.toString();
    }
}
