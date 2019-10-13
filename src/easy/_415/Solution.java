package easy._415;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/13
 *     desc   : 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * </pre>
 */
public class Solution {
    /**
     * 注意：
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     */
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0&& len2 == 0) return "";
        if(len1 == 0) return num2;
        if(len2 == 0) return num1;
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int carry = 0;//进位
        String res="";
        while (index1>=0&&index2>=0){
            int c1 = num1.charAt(index1)-'0';
            int c2 = num2.charAt(index2)-'0';
            res = (c1+c2+carry)%10+res;
            carry = (c1+c2+carry)>=10?1:0;
            index1--;
            index2--;
        }
        while (index1>=0){
            int c1 = num1.charAt(index1)-'0';
            res = (c1+carry)%10+res;
            carry = (c1+carry)>=10?1:0;
            index1--;
        }
        while (index2>=0){
            int c2 = num2.charAt(index2)-'0';
            res = (c2+carry)%10+res;
            carry = (c2+carry)>=10?1:0;
            index2--;
        }
        return carry==1?"1"+res:res;
    }


    //Better
    public String addStringsBetter(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0&& len2 == 0) return "";
        if(len1 == 0) return num2;
        if(len2 == 0) return num1;
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        int carry = 0;//进位
        StringBuilder s = new StringBuilder();
        while (index1>=0||index2>=0||carry!=0){
            if(index1>=0) carry+=num1.charAt(index1--)-'0';
            if(index2>=0) carry+=num2.charAt(index2--)-'0';
            s.append(carry%10);
            carry/=10;
        }
        return s.reverse().toString();

    }
}
