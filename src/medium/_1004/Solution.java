package medium._1004;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/03
 *     desc   :
 * </pre>
 */
public class Solution {
    /**
     * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
     * 返回仅包含 1 的最长（连续）子数组的长度。
     * <p>
     * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：
     * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     */
    public int longestOnes(int[] A, int K) {
        if (A.length == 0) return 0;
        int firstZero = 0; //记录第一个0的位置
        int res = 0;
        int count = 0;//记录个数
        int k = K;//记录翻转次数
        int i = 0;//移动
        while (i<A.length){
            if (A[i] == 0) {
                if (k == K) firstZero = i;//记录第一个0的位置
                if (k != 0) {
                    k--;
                    count++;
                    i++;
                } else {
                    res = Math.max(res, count);
                    k = K;
                    count = 0;
                    i = firstZero+1;
                }
            } else {
                count++;
                i++;
            }
        }
        return Math.max(res,count);
    }

    //滑动窗口
    public int longestOnesBetter(int[] A, int K) {
        if(A.length == 0) return 0;
        int res = 0;
        for (int left = 0,right = 0; right < A.length; right++) {
            if(A[right]==0){
                if(K==0){
                    while (A[left]==1){
                        left++;
                    }
                    left++;
                }else {
                    K--;
                }
            }
            res = Math.max(right-left+1,res);
        }
        return res;
    }
}
