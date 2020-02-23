package 动态规划.medium._139;

import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/29
 *     desc   : 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *     说明：拆分时可以重复使用字典中的单词。你可以假设字典中没有重复的单词。
 * </pre>
 */
public class Solution {
    /**
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s,wordDict,new HashMap<>());
    }

    //用hash表来记录访问过的字串是否存在在字典中，自顶向下
    private boolean backtrack(String s,List<String> wordDict,HashMap<String,Boolean> map){
        if(map.containsKey(s)) return map.get(s); //如果是访问过的字串，则返回hash表的值
        if(s == null || s.length() == 0) return true;
        for (int i = 1; i < s.length() +1; i++) {
            if(wordDict.contains(s.substring(0,i))){
                map.put(s.substring(0,i),true); //字串存在字典中
                if(backtrack(s.substring(i),wordDict,map)) {
                    return true;
                }
            }
        }
        map.put(s,false); //字串不存在字典中
        return false;
    }

    //动态规划，备忘录，自底向上
    public boolean wordBreakDb(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
