package easy._345;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/12
 *     desc   : 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * </pre>
 */
public class Solution {
    /**
     * 输入: "hello"
     * 输出: "holle"
     *
     * 输入: "leetcode"
     * 输出: "leotcede"
     */
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c:s.toCharArray()){
            if(isVowel(c)) vowels.add(c);
        }
        StringBuilder res = new StringBuilder();
        int index = vowels.size()-1;
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                res.append(vowels.get(index--));
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    private boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }


    //hashset的使用
    public String reverseVowelsByHashset(String s) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','o','e','i','u','A','O','E','I','U'));
        char[] res = new char[s.length()];
        int left = 0,right = s.length()-1;
        while (left<=right){
            char lC = s.charAt(left);
            char rC = s.charAt(right);
            if(!set.contains(lC)){
                res[left++] = lC;
            }else if(!set.contains(rC)){
                res[right--] = rC;
            }else {
                res[left++] = rC;
                res[right--] = lC;
            }
        }
        return new String(res);
    }
}
