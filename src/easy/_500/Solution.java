package easy._500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/08
 *     desc   : 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * </pre>
 */
public class Solution {
    /**
     * 输入: ["Hello", "Alaska", "Dad", "Peace"]
     * 输出: ["Alaska", "Dad"]
     *
     * 注意：
     * 你可以重复使用键盘上同一字符。
     * 你可以假设输入的字符串将只包含字母。
     */
    public String[] findWords(String[] words) {
        if(words.length == 0) return words;
        List<String> res = new ArrayList<>();
        //26个字母所在对应的行号
        int[] wordLine = {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        for(String word:words){
            //都转换为小写
            char[] wordToLower = word.toLowerCase().toCharArray();
            boolean isSame = true;
            for (int i = 0; i <wordToLower.length-1 ; i++) {
                if(wordLine[wordToLower[i]-'a']!=wordLine[wordToLower[i+1]-'a']){
                    isSame = false;
                    break;
                }
            }
            if(isSame) res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
}
