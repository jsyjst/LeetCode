package 数组.medium._006;

import java.util.ArrayList;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/24
 *     desc   : 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * </pre>
 */
public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows == 1) return s;
        if(len <= numRows) return s;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows;i++) list.add(new StringBuilder());
        boolean down = false;
        int index = 0;
        for(char c:s.toCharArray()){
            list.get(index).append(c);
            if(index == 0 || index == numRows - 1) down = !down;
            index = down ? index + 1 : index - 1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder builder : list) res.append(builder.toString());
        return res.toString();
    }
}
