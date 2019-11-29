package easy._720;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/11/28
 *     desc   : 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
 *     若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * </pre>
 */
public class Solution {

    public String longestWord(String[] words) {
        String res="";
        Arrays.sort(words);
        HashSet<String> set = new HashSet<>();
        for(String word:words){
            if(word.length()==1||set.contains(word.substring(0,word.length()-1))){
                res = word.length()>res.length()?word:res;
                set.add(word);
            }
        }
        return res;
    }
}
