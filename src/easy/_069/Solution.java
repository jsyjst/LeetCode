package easy._069;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/15
 *     desc   : 实现 int sqrt(int x) 函数。
 *     计算并返回 x 的平方根，其中 x 是非负整数。
 *     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * </pre>
 */
public class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int left = 1;
        int right = x;
        int res;
        while (true) {
            res = left + (right - left) / 2;
            if (res <= x / res) {
                left = res + 1;
                if ((res + 1) > x / (res + 1)) {
                    return res;
                }else if((res + 1) == x / (res + 1)){
                    return res+1;
                }
            } else {
                right = res -1;
            }

        }
    }
}
