package medium._187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/06
 *     desc   : 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。
 *     在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *     编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 * </pre>
 */
public class Solution {
    /**
     * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
     */
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> helper = new HashSet<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String s1 = s.substring(i,i+10);
            if(!set.add(s1)) helper.add(s1);
        }
        return new ArrayList<>(helper);
    }

}
