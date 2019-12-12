package swordOffer._7变态跳台阶;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/12
 *     desc   : 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * </pre>
 */
public class Solution {
    public int JumpFloorII(int target) {
        if(target <= 2) return target;
        int res = 4;
        for(int i = 4; i <= target; i++){
            res = res * 2;
        }
        return res;
    }
}
