package medium._043;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/30
 *     desc   : 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *              说明：
 *              num1 和 num2 的长度小于110。
 *              num1 和 num2 只包含数字 0-9。
 *              num1 和 num2 均不以零开头，除非是数字 0 本身。
 *              不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * </pre>
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(multiply("6","22"));
    }

    /**
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * <p>
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     */

    /**
     * 核心：i + j 正好对应俩个数字相乘后所在的位置
     * 比如 0 + 0 就应该是个位， 0 + 1 就是十位， 1 + 1 百位。
     * @param num1 字符串
     * @param num2 字符串
     * @return 相乘后的结果
     */
    public static String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        StringBuilder result = new StringBuilder();
        //m位数乘n位数，结果最多只能是m+n-1位数
        int resultInt[] = new int[num1.length()+ num2.length()-1];
        for (int i = num1.length()-1; i >=0; i--) {
            int n1 = num1.charAt(i)-'0';
            for (int j = num2.length()-1; j >=0 ; j--) {
                int n2 = num2.charAt(j) - '0';
                resultInt[i+j] += n1 * n2;
                if(resultInt[i+j]>=10&&(i+j)!=0){
                    resultInt[i+j-1] += resultInt[i+j]/10;
                    resultInt[i+j] = resultInt[i+j]%10;
                }
            }
        }
        for (int i = 0; i<num1.length()+num2.length()-1; i++) {
           result.append(resultInt[i]);
        }
        return result.toString();
    }
}
