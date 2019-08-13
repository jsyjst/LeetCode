package easy._202;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/13
 *     desc   : 编写一个算法来判断一个数是不是“快乐数”。
 *     一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 *     然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 *     如果可以变为 1，那么这个数就是快乐数。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 19
     * 输出: true
     * 解释:
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return happy(set,n);
    }

    private boolean happy(Set<Integer> set,int n){
        if(set.contains(n)) return false;
        if(n == 1) return true;
        set.add(n);
        int sum = 0;
        while (n!=0){
            int num = n%10;
            sum += (num*num);
            n/=10;
        }
        return happy(set,sum);
    }
}
