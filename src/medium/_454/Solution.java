package medium._454;

import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/26
 *     desc   :
 * </pre>
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        //查找表mapAB：key为A+B的和，value为A+B和出现的次数
        HashMap<Integer,Integer> mapAB = new HashMap<>();
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len; j++) {
                int sum = A[i]+B[j];
                mapAB.put(sum,mapAB.getOrDefault(sum,0)+1);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = -(C[i]+D[j]);
                res+=mapAB.getOrDefault(sum,0);
            }
        }
        return res;
    }
}
