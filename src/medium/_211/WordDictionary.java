package medium._211;

import medium._208.Trie;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/17
 *     desc   : 设计一个支持以下两种操作的数据结构：
 *     void addWord(word)
 *     bool search(word)
 *     search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * </pre>
 */

public class WordDictionary {
    class TireNode{
        TireNode[] child;
        boolean isEnd;
        TireNode(){
            child = new TireNode[26];
            isEnd = false;
        }
    }
    /**
     * addWord("bad")
     * addWord("dad")
     * addWord("mad")
     * search("pad") -> false
     * search("bad") -> true
     * search(".ad") -> true
     * search("b..") -> true
     * 你可以假设所有单词都是由小写字母 a-z 组成的。
     */
    /** Initialize your data structure here. */
    private TireNode root;
    public WordDictionary() {
        root = new TireNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TireNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.child[c-'a']==null){
                cur.child[c-'a'] = new TireNode();
            }
            cur = cur.child[c-'a'];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word,0,root);
    }
    private boolean helper(String word,int len,TireNode root){
        if(len == word.length()&&root.isEnd) return true;
        if(len == word.length()) return false;
        char c = word.charAt(len);
        int index = c-'a';
        if(c == '.'){
            for (int i = 0; i < 26; i++) {
                if(root.child[i] != null){
                    TireNode cur = root.child[i];
                    if(helper(word,len+1,cur)){
                        return true;
                    }
                }
            }
        }else {
            if(root.child[index] == null) return false;
            return helper(word,len+1,root.child[index]);
        }
        return false;
    }
}
