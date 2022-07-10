package medium._006;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        if (len <= 2 || numRows <= 1) {
            return s;
        }
        List<StringBuilder> lines = new ArrayList<>();
        // 給每一行赋值StringBuilder，最终结果会等于每一行相加
        for(int i = 0 ; i < numRows; i++) {
            lines.add(new StringBuilder());
        }
        int i = 0;
        // 标记是从上到下，还是从下到上排序
        int flag = -1;
        for(char c : s.toCharArray()) {
            lines.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder line : lines) {
            res.append(line);
        }
        return res.toString();
    }
}
