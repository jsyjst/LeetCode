package medium._127;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/24
 *     desc   : 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
 *              转换需遵循如下规则：
 *              每次转换只能改变一个字母。
 *              转换过程中的中间单词必须是字典中的单词。
 *              说明:如果不存在这样的转换序列，返回 0。
 *              所有单词具有相同的长度。
 *              所有单词只由小写字母组成。
 *              字典中不存在重复的单词。
 *              你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * 输出: 5
     * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     *      返回它的长度 5。
     *
     *
     *  输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * 输出: 0
     * 解释: endWord "cog" 不在字典中，所以无法进行转换。
     */

    //经典BFS解法
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>(); //少不了队列
        boolean[] visited = new boolean[wordList.size()]; //少不了标记
        int res = 1;
        queue.offer(beginWord);  //入队
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if(visited[j]) continue;
                    String word = wordList.get(j);
                    if(canChange(s,word)){
                        if(word.equals(endWord)) return res;
                        queue.offer(word);
                        visited[j] = true;
                    }
                }
            }
        }
        return 0;

    }

    private boolean canChange(String s1,String s2){
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!= s2.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return true;
    }

}
