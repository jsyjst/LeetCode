package medium._331;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/12
 *     desc   : 序列化二叉树的一种方法是使用前序遍历。
 *     当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #
 * </pre>
 */
public class Solution {
    /**
     *      _9_
     *     /   \
     *    3     2
     *   / \   / \
     *  4   1  #  6
     * / \ / \   / \
     * # # # #   # #
     * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
     * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
     * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
     * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
     *
     * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
     * 输出: true
     *
     * 输入: "1,#"
     * 输出: false
     *
     * 输入: "9,#,#,1"
     * 输出: false
     */
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int num = 0;//记录#的个数
        for(int i = n-1; i>=0;i--){
            if(preorder.charAt(i) == ',')
                continue;
            if(preorder.charAt(i) == '#')
                num++;
            else{
                while(i>=0 && preorder.charAt(i) != ',')//节点数字可能有多位
                    i--;
                if(num >= 2)//#的个数>=2，消除2个#，消除一个节点数字并转换成#，即num-1
                    num--;
                else
                    return false;//#的个数不足2，证明false
            }
        }
        return num == 1;
    }
}
