package medium._208;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/16
 *     desc   : 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *     Trie trie = new Trie();
 *     trie.insert("apple");
 *     trie.search("apple");   // 返回 true
 *     trie.search("app");     // 返回 false
 *     trie.startsWith("app"); // 返回 true
 *     trie.insert("app");
 *     trie.search("app");     // 返回 true
 *     说明:你可以假设所有的输入都是由小写字母 a-z 构成的。保证所有输入均为非空字符串。
 * </pre>
 */
public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.child[c -'a'] == null){
                cur.child[c-'a'] = new TrieNode();
            }
            cur = cur.child[c-'a'];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.child[c-'a'] == null) return false;
            cur = cur.child[c-'a'];
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.child[c-'a'] == null) return false;
            cur = cur.child[c-'a'];
        }
        return true;
    }
}

class TrieNode{
    TrieNode[] child;//记录孩子节点
    boolean isEnd; //当前节点是否为一个单词的结束字母
    TrieNode(){
        child = new TrieNode[26];
        isEnd = false;
    }
}
