package medium._061;

import common.ListNode;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/12
 *     desc   : 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * </pre>
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i <= 2; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        head.next = null;
        System.out.println(rotateRight(p, 4));
    }

    /**
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * <p>
     * 示例 2:
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     */

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 2;
        ListNode p = head.next;
        while (p.next!=null){
            len++;
            p = p.next;
        }
        ListNode last = p;//记录最后的结点
        if (k % len == 0) return head;  //如果移动的位置刚好一个长度的倍数的话，就直接返回
        int i = 1;
        ListNode  p1, p2;
        p = p1 = p2 = head;
        while (p != null) {
            if ((len + 1) - k % len == i) { //如果是旋转后的首结点
                head = p;
                p2.next = null;
            } else if ((len + 1) - k % len == i + 1) {//记住旋转后首结点的前一个位置
                p2 = p;
            }
            i++;
            p = p.next;
        }
        last.next = p1;
        return head;
    }

    /**
     * 优化
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRightBetter(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 2;
        ListNode p = head.next;
        while (p.next!=null){
            len++;
            p = p.next;
        }
        ListNode last = p;//记录最后的结点
        if (k % len == 0) return head;  //如果移动的位置刚好一个长度的倍数的话，就直接返回
        ListNode  p1;
        p = p1 = head;
        k = len - k%len;//k为旋转点，k+1即为新结点
        while (--k>0){//找到旋转点
            p = p.next;
        }
        head = p.next;  //旋转后的首结点
        p.next = null;
        last.next = p1;
        return head;
    }
}
