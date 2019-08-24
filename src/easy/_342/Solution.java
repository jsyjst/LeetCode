package easy._342;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/24
 *     desc   : 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 16
     * 输出: true
     */
    public boolean isPowerOfFour(int num) {
        if(num<1) return false;
        while (num % 4 == 0){
            num/=4;
        }
        return num==1;
    }

    //best
    public boolean isPowerOfFourBest(int num) {
        if(num<1 || (num&(num-1))!=0) return false;
        return num%3==1;
    }
}
