package medium._423;

import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/16
 *     desc   : 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * </pre>
 */
public class Solution {
    /**
     * 输入只包含小写英文字母。
     * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
     * 输入字符串的长度小于 50,000。
     *
     * 输入: "owoztneoer"
     * 输出: "012" (zeroonetwo)
     */
    public String originalDigits(String s) {
        int[] count = new int[26+'a'];
        for(char c:s.toCharArray()){
            count[c]++;
        }
        int[] numCount= new int[10];
        numCount[0] = count['z'];
        numCount[2] = count['w'];
        numCount[4] = count['u'];
        numCount[6] = count['x'];
        numCount[8] = count['g'];

        numCount[3] = count['h']-numCount[8];
        numCount[5] = count['f']-numCount[4];
        numCount[7] = count['s']-numCount[6];

        numCount[1] = count['o']-numCount[0]-numCount[2]-numCount[4];
        numCount[9] = count['i']-numCount[5]-numCount[6]-numCount[8];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < numCount[i]; j++) {
                res.append(i);
            }
        }
        return res.toString();

    }

}
