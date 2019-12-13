package swordOffer._9数值的整数次方;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/13
 *     desc   : 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * </pre>
 */
public class Solution {
    public double Power(double base, int exponent) {
        if(base == 0.0) return 0.0;
        double res = 1.0;
        int e = exponent > 0 ? exponent : -exponent;
        for(int i = 1; i <= e; i++){
            res *= base;
        }
        return exponent > 0 ? res : 1 / res;
    }
}
