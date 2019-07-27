package medium._133;

import common.graph.Node;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/27
 *     desc   : 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。
 *     图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 * </pre>
 */
public class Solution {
    /**
     * 1-----2
     * |     |
     * 3-----4
     *
     *输入：
     * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
     *
     * 解释：
     * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
     * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
     * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
     * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
     *
     * 提示：
     *
     * 节点数介于 1 到 100 之间。
     * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
     * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
     * 必须将给定节点的拷贝作为对克隆图的引用返回。
     */
    //BFS
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node res = new Node(node.val,new ArrayList<>());
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();//队列少不了
        map.put(node,res);
        queue.offer(node);
        while (!queue.isEmpty()){
            Node G = queue.poll();
            for (Node n:G.neighbors) {
                if(!map.containsKey(n)){
                    map.put(n,new Node(n.val,new ArrayList<>()));
                    queue.offer(n);
                }
                map.get(G).neighbors.add(map.get(n));
            }
        }
        return res;
    }
}
