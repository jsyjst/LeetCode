package easy._976;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/26
 *     desc   : 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *     如果不能形成任何面积不为零的三角形，返回 0。
 * </pre>
 */
public class Solution {
    /**
     * 输入：[2,1,2]
     * 输出：5
     *
     * 输入：[1,2,1]
     * 输出：0
     *
     * 输入：[3,2,3,4]
     * 输出：10
     *
     * 输入：[3,6,2,3]
     * 输出：8
     *
     * 3 <= A.length <= 10000
     * 1 <= A[i] <= 10^6
     */

    //dfs,回溯
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length-1; i >=2 ; i--) {
            int a = A[i];
            int b = A[i-1];
            int c = A[i-2];
            if(a<b+c) return a+b+c;
        }
        return 0;
    }
}
