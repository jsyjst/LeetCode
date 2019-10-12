package medium._413;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/12
 *     desc   : 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *     如果满足以下条件，则称子数组(P, Q)为等差数组：元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *     函数要返回数组 A 中所有为等差数组的子数组个数。
 * </pre>
 */
public class Solution {
    /**
     * A = [1, 2, 3, 4]
     * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
     */
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n<3) return 0;
        int[] dp =  new int[n];
        int res = 0;
        for (int i = 2; i<n  ; i++) {
            if(A[i]+A[i-2]==2*A[i-1]){
                dp[i] = dp[i-1]+1;
                res+=dp[i];
            }
        }
        return res;
    }


    //公式法，更优
    public int numberOfArithmeticSlicesBetter(int[] A) {
        int n = A.length;
        if(n<3) return 0;
        int count = 0;
        int res = 0;
        for (int i = 2; i<n  ; i++) {
            if(A[i]+A[i-2]==2*A[i-1]){
                count++;
            }else {
                res+=count*(count+1)/2;
                count = 0;
            }
        }
        return res+count*(count+1)/2;
    }
}
