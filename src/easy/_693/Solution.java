package easy._693;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/21
 *     desc   : 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等
 * </pre>
 */
public class Solution {
    /**
     * 输入: 5
     * 输出: True
     * 解释:
     * 5的二进制数是: 101
     *
     * 输入: 7
     * 输出: False
     * 解释:
     * 7的二进制数是: 111
     */
    public boolean hasAlternatingBits(int n) {
        while (n>0){
            int cur = n&1;
            int next =  (n>>1)&1;
            if(cur == next) return false;
            n>>=1;
        }
        return true;
    }
}
