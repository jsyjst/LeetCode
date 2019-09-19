package easy._367;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/19
 *     desc   : 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *     说明：不要使用任何内置的库函数，如  sqrt。
 * </pre>
 */
public class Solution {
    /**
     * 输入：16
     * 输出：True
     *
     * 输入：14
     * 输出：False
     */
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        int mid;
        while (left<=right){
            mid = left +(right-left)/2;
            if(mid==(num*1.0)/mid) return true;
            if(mid<(num*1.0)/mid){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
}
