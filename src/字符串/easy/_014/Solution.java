package 字符串.easy._014;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/07
 *     desc   : 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *              说明:所有输入只包含小写字母 a-z 。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     */
    public String longestCommonPrefixMine(String[] strs) {
        String commPrefix="";
        String longestPrefix="";
        if(strs.length == 1)  return strs[0];
        for (int i = 0; i < strs.length; i++) {
            if(i == 0){
                for (int j = 0; j < Math.min(strs[i].length(),strs[i+1].length()); j++) {
                    if(strs[i].charAt(j) == strs[i+1].charAt(j)){
                        commPrefix+=strs[i].charAt(j);
                    }else {
                        break;
                    }
                }
                longestPrefix = commPrefix;
                i++;
                if(commPrefix.equals("")) break;
            }else {
                longestPrefix="";
                for (int j = 0; j < Math.min(commPrefix.length(),strs[i].length()); j++) {
                    if(commPrefix.charAt(j)== strs[i].charAt(j)){
                        longestPrefix+=commPrefix.charAt(j);
                    }else {
                        break;
                    }
                }
                commPrefix = longestPrefix;
                if(longestPrefix.equals("")) break;
            }

        }
        return longestPrefix;
    }
    /**
     * 评论
     * 所求的最长公共前缀子串一定是每个字符串的前缀子串。
     * 所以随便选择一个字符串作为标准，把它的前缀串，与其他所有字符串进行判断，看是否是它们所有人的前缀子串。
     * 这里的时间性能是O(m*n*m)。
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        if(strs.length==0) return "";
        StringBuilder prefix= new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i>=strs[j].length()||strs[j].charAt(i)!=c ){
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
}
