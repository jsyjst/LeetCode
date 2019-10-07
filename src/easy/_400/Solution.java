package easy._400;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/24
 *     desc   : 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 *     注意:n 是正数且在32为整形范围内 ( n < 231)。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * 11
     * 输出:
     * 0
     * 说明:
     * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
     */
    public int findNthDigit(int n) {
        if(n<10) return n;
        int len = 0;//单个数字的长度
        long nextSize = (long)Math.pow(10,len)*(len+1)*9;

        //确定n所处的位置
        while (n>nextSize){
            n-=nextSize;
            len++;
            nextSize = (long)Math.pow(10,len)*(len+1)*9;
        }
        String resStr = String.valueOf((long)Math.pow(10,len)+(n-1)/(len+1));
        return resStr.charAt(n-(n-1)/(len+1)*(len+1)-1)-'0';
    }
}
