package medium._477;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/09
 *     desc   : 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。计算一个数组中，任意两个数之间汉明距离的总和。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        int[] nums={4,14,2};
        System.out.println(totalHammingDistance(nums));
    }
    /**
     * 输入: 4, 14, 2
     * 输出: 6
     * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
     * 所以答案为：
     * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     * 注意:
     * 数组中元素的范围为从 0到 10^9。
     * 数组的长度不超过 10^4。
     */
    public static int totalHammingDistance(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int oneCount = 0;
            int temp = 0;
            for (int j = 0; j < len; j++) {
                if((nums[j]&1)==1) oneCount++;
                nums[j]>>=1;
                temp += nums[j] == 0?1:0;
            }
            res+=oneCount*(len-oneCount);
            if(temp == len) break;
        }
        return res;
    }
}
