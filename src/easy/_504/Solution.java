package easy._504;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/09
 *     desc   : 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 100
     * 输出: "202"
     * 输入: -7
     * 输出: "-10"
     */
    public String convertToBase7(int num) {
        if(num==0) return "0";
        String res = "";
        boolean isPositive = true;
        if(num<0) isPositive = false;
        num = Math.abs(num);
        while (num/7!=0){
            res = num%7+res;
            num/=7;
        }
        res = num%7+res;
        return isPositive?res:"-"+res;
    }
}
