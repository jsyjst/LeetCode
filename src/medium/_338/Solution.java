package medium._338;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/17
 *     desc   : 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 2
     * 输出: [0,1,1]
     * <p>
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     * <p>
     * 进阶：给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
     */


    //简单
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            while (num != 0) {
                if ((num & 1) == 1) count++;
                num >>= 1;
            }
            res[i] = count;
        }
        return res;
    }

    //一次循环，更优
    //只有两种情况，奇数则比前一个数多1，偶数则与i/2一样，因为i/2等于该数右移1位，也就是抹去了最后一个0，所以相等
    public int[] countBitsBetter(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 0; i <= num ; i++) {
            if((i&1)==1){
                res[i] = res[i-1]+1;
            }else {
                res[i] = res[i/2];
            }
        }
        return res;
    }
}
