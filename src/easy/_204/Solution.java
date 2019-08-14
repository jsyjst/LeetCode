package easy._204;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/14
 *     desc   : 统计所有小于非负整数 n 的质数的数量。
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        System.out.println(countPrimes(10));
    }
    /**
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     */
    public static int countPrimes(int n) {
        int res = 0;
        boolean[] sign = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(!sign[i]){
                res++;
                for (int j = i+i; j <n ; j+=i) {
                    sign[j] = true;
                }
            }
        }
        return res;
    }

}
