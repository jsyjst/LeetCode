package easy._443;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/22
 *     desc   : 给定一组字符，使用原地算法将其压缩。
 *     压缩后的长度必须始终小于或等于原数组长度。
 *     数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *     在完成原地修改输入数组后，返回数组的新长度。。
 * </pre>
 */
public class Solution {
    /**
     * 输入：
     * ["a","a","b","b","c","c","c"]
     * 输出：
     * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
     * 说明：
     * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
     */
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        StringBuilder s = new StringBuilder(String.valueOf(chars[0]));
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]!=chars[i-1]){
                if(count != 1) s.append(count);
                s.append(chars[i]);
                count = 1;
            }else {
                count++;
            }
        }
        if(count!=1) s.append(count);
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();

    }

    //优化空间复杂度
    public int compressBetter(char[] chars) {
        if(chars.length == 1) return 1;
        int size = 0;//目标数组的下标
        int left = 0;//相同字母最开始的下标
        for (int right = 1; right <= chars.length; right++) {
            if(right == chars.length||chars[right]!=chars[left]){
                chars[size++] = chars[left];//更新字符
                if(right - left > 1){
                    for (char c:String.valueOf(right-left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return chars.length;
    }
}
