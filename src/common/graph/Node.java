package common.graph;

import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/27
 *     desc   : 无向图的节点
 * </pre>
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val, List<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}
