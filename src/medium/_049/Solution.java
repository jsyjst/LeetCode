package medium._049;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/01
 *     desc   : 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *              说明：
 *              所有输入均为小写字母。
 *              不考虑答案输出的顺序。
 * </pre>
 */
public class Solution {
    /**
     * 示例:
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */

    /**
     * 护一个映射 map : {String -> List}，其中每个键 K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于 K。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortS = String.valueOf(c);
            if(!map.containsKey(sortS)){
                map.put(sortS,new ArrayList<>());
            }
            map.get(sortS).add(s);

        }
        return new ArrayList<>(map.values());

    }
}
