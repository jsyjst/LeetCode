package common;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/19
 *     desc   : 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *     初始状态下，所有 next 指针都被设置为 NULL
 * </pre>
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
