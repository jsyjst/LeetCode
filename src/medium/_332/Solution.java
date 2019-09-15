package medium._332;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/15
 *     desc   : 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 *     所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 *     说明:如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。
 *     例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 *     所有的机场都用三个大写字母表示（机场代码）。
 *     假定所有机票至少存在一种合理的行程。
 * </pre>
 */
public class Solution {
    /**
     * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     *
     * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
     */

    private List<String> res =  new LinkedList<>();
    private HashMap<String,PriorityQueue<String>> side = new HashMap<>();  //优先级队列，会将字符串最小的放在队头
    public List<String> findItinerary(List<List<String>> tickets) {
        //邻接矩阵
        for(List<String> ticket:tickets){
            String key = ticket.get(0);
            String value = ticket.get(1);
            if(!side.containsKey(key)){
                PriorityQueue<String> queue = new PriorityQueue<>();
                side.put(key,queue);
            }
            side.get(key).add(value);
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String ticket){
        PriorityQueue<String> airport = side.get(ticket);
        while (airport!=null&&!airport.isEmpty()){
            dfs(airport.poll());
        }
        ((LinkedList)res).addFirst(ticket);
    }
}
