package medium._310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/08
 *     desc   : 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。
 *     图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
 *     给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 *     格式:该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 *     你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 *
 * </pre>
 */
public class Solution {
    /**
     * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
     *
     *         0
     *         |
     *         1
     *        / \
     *       2   3
     *
     * 输出: [1]
     *
     * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     *
     *      0  1  2
     *       \ | /
     *         3
     *         |
     *         4
     *         |
     *         5
     *
     * 输出: [3, 4]
     *
     * 说明:
     *  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
     * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
     */


    //方法：构建图，遍历图，找出叶子节点，去除叶子节点，知道图中节点为2或1，则返回剩下的节点
    private boolean[][] graph;  //邻接矩阵
    private boolean[] visited;   //是否访问
    private int[] e;   //边集合
    private Queue<Integer> queue;  //用来遍历图
    private List<Integer> res;//根节点
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph = new boolean[n][n];
        visited = new boolean[n];
        e = new int[n];
        queue = new LinkedList<>();
        res = new ArrayList<>();

        //构建图
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
            e[edge[0]]++;
            e[edge[1]]++;
        }
        //遍历图
        while (n>2){
            //找出叶子节点
            findLeafNode();
            while (!queue.isEmpty()){
                int node = queue.poll();
                System.out.println(node);
                n--;
                e[node]--;
                visited[node] = true;
                for (int i = 0; i < graph[node].length; i++) {
                    if(graph[node][i]){
                        e[i]--;
                        graph[node][i] = false;
                        graph[i][node] = false;
                    }
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) res.add(i);
        }
        return res;
    }

    //找出叶子节点
    private void findLeafNode(){
        for (int i = 0; i < e.length; i++) {
            if(e[i] == 1) queue.offer(i);
        }
    }
}
