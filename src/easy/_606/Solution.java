package easy._606;

import common.tree.TreeNode;

import java.util.HashSet;
import java.util.Stack;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/17
 *     desc   : 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串
 *     空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * </pre>
 */
public class Solution {
    /**
     * 输入: 二叉树: [1,2,3,4]
     *        1
     *      /   \
     *     2     3
     *    /
     *   4
     *
     * 输出: "1(2(4))(3)"
     *
     * 解释: 原本将是“1(2(4)())(3())”，
     * 在你省略所有不必要的空括号对之后，
     * 它将是“1(2(4))(3)”。
     */
    public String tree2str(TreeNode t) {
        if(t==null) return "";
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder resBuilder = new StringBuilder();
        HashSet<TreeNode> set = new HashSet<>();
        stack.push(t);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(set.contains(cur)){
                resBuilder.append(")");
                stack.pop();
            }else {
                set.add(cur);
                resBuilder.append("(").append(cur.val);
                if(cur.left ==null&&cur.right!=null) resBuilder.append("()");
                if(cur.right!=null) stack.push(cur.right);
                if(cur.left!=null) stack.push(cur.left);
            }
        }
        return resBuilder.substring(1,resBuilder.length()-1);
    }
}
