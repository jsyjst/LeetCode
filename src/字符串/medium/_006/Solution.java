package 字符串.medium._006;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/04/29
 *     desc   :将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *            比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *                   L   C   I   R
 *                  E T O E S I I G
 *                 E   D   H   N
 *          之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * <p>
     * <p>
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */
    public static void main(String[] args){
        System.out.println(convert("abc",2));
    }
    public static String convert(String s, int numRows) {
        List<StringBuilder> rowList = new ArrayList<>();
        //根据行来确定StringBuilder的个数
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rowList.add(new StringBuilder());
        }
        int currentRow = 0;
        boolean down = false;
        for (char c : s.toCharArray()) {
            rowList.get(currentRow).append(c);
            //如果是当前行为第一行或者最后一行，则改变方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                down = !down;
            }
            currentRow += down ? 1 : -1;
        }
        //输出排列后的字符串
        StringBuilder covertString = new StringBuilder();
        for(StringBuilder stringBuilder :rowList){
            covertString.append(stringBuilder);
        }
        return covertString.toString();
    }
}
