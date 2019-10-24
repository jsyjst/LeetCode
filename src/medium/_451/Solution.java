package medium._451;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/24
 *     desc   : 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * "tree"
     * 输出:
     * "eert"
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案
     *
     * 输入:
     * "Aabb"
     * 输出:
     * "bbAa"
     * 解释:
     * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
     * 注意'A'和'a'被认为是两种不同的字符。
     */
    public String frequencySort(String s) {
        if(s.length()<=2) return s;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder res = new StringBuilder();
        List<Character> keyList = new ArrayList<>(map.keySet());
        keyList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for(char c:keyList){
            for (int i = 0; i < map.get(c); i++) {
                res.append(c);
            }
        }
        return res.toString();

    }
}
