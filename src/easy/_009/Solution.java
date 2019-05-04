package easy._009;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/04
 *     desc   : 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */

    //复杂度：isPalindrome1>isPalindrome2>isPalindrome3

    /**
     * 利用StringBuilder翻转来实现
     * @param x 整数
     * @return 是否为回文数字
     */
    public boolean isPalindrome1(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(x));
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
    public boolean isPalindrome2(int x){
        if(x<0) return false;
        String num = String.valueOf(x);
        int left = 0,right = num.length()-1;
        while (left< num.length()/2){
            if(num.charAt(left)!=num.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * 题解：
     * 1.不进行String类型转换
     * 2.将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
     * @param x
     * @return
     */
    public boolean isPalindrome3(int x){
        if(x<0 || (x%10==0&&x!=0)) return false;
        int turnNum =0;//翻转数字
        while (x>turnNum){
            turnNum = turnNum*10+x%10;
            x = x/10;
        }
        return turnNum == x||x == turnNum/10;
    }
}
