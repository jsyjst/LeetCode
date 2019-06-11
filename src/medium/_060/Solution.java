package medium._060;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/11
 *     desc   :给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *              按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *              "123"
 *              "132"
 *              "213"
 *              "231"
 *              "312"
 *              "321"
 *              给定 n 和 k，返回第 k 个排列。
 *              说明：
 *              给定 n 的范围是 [1, 9]。
 *              给定 k 的范围是[1,  n!]。
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        System.out.println(getPermutation(3,3));
    }
    /**
     * 示例 1:
     * 输入: n = 3, k = 3
     * 输出: "213"
     * 示例 2:
     * 输入: n = 4, k = 9
     * 输出: "2314"
     */
    public static String getPermutation(int n, int k) {
        if(n ==1) return n+"";
        ArrayList<String> resList = new ArrayList<>();
        int[] visit = new int[n+1];
        backtrack(resList,new StringBuilder(),visit,n,k);
        return resList.get(resList.size()-1);
    }


    /**
     * 回溯法，时间复杂度和空间复杂度过于复杂
     * @param resList
     * @param res
     * @param visit
     * @param n
     * @param k
     */
    private static void backtrack(ArrayList<String> resList,StringBuilder res,int[] visit,int n,int k){
        if(resList.size() == k){
            return;
        }
        if(res.length() == n){
            resList.add(res.toString());
            return;
        }
        StringBuilder resBuilder = new StringBuilder(res);
        for (int i = 1; i <= n; i++) {
            if(visit[i] == 1){
                continue;
            }
            resBuilder.append(i);
            visit[i] = 1;
            backtrack(resList,resBuilder,visit,n,k);
            visit[i] = 0;
            resBuilder.delete(resBuilder.length()-1,resBuilder.length());
        }
    }


    /**
     * 规律法：
     *         确定第一位:
     *             k = 14(从0开始计数)
     *             index = k / (n-1)! = 2, 说明第15个数的第一位是3
     *             更新k
     *             k = k - index*(n-1)! = 2
     *         确定第二位:
     *             k = 2
     *             index = k / (n-2)! = 1, 说明第15个数的第二位是2
     *             更新k
     *             k = k - index*(n-2)! = 0
     *         确定第三位:
     *             k = 0
     *             index = k / (n-3)! = 0, 说明第15个数的第三位是1
     *             更新k
     *             k = k - index*(n-3)! = 0
     *         确定第四位:
     *             k = 0
     *             index = k / (n-4)! = 0, 说明第15个数的第四位是4
     *         最终确定n=4时第15个数为3214
     * @param n
     * @param k
     * @return
     */
    public static String getPermutationBetter(int n, int k) {
        if(n==1) return "1";
        StringBuilder result =new StringBuilder();
        int [] factorials = new int[n+1];
        List<Integer> nums = new ArrayList<>();
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
           nums.add(i);
           factorials[i]  = factorials[i-1]*i;
        }
        k--;
        for (int i = n-1; i >=0 ; i--) {
            int index = k/factorials[i];
            result.append(nums.remove(index));
            k = k-factorials[i]*index;
        }
        return result.toString();
    }
}
