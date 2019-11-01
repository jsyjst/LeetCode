package easy._476;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/01
 *     desc   : 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *     注意:
 *     给定的整数保证在32位带符号整数的范围内。
 *     你可以假定二进制数不包含前导零位。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 5
     * 输出: 2
     * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
     *
     * 输入: 1
     * 输出: 0
     * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0
     */
    public int findComplement(int num) {
        int temp = num;
        int num2 = 1;
        while (temp!=0){
            num2<<=1;
            temp>>=1;
        }
        //num2的位数会比num多一
        //比如此时num=5（101），num2会为1000，减一后变为111；
        num2-=1;
        return num^num2;
    }
}
