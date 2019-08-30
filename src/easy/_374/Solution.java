package easy._374;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/30
 *     desc   : 我们正在玩一个猜数字游戏。 游戏规则如下：
 *     我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 *     每次你猜错了，我会告诉你这个数字是大了还是小了。
 *     你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *          -1 : 我的数字比较小
 *          1 : 我的数字比较大
 *          0 : 恭喜！你猜对了！
 * </pre>
 */
public class Solution  extends GuessGame{
    /**
     * 输入: n = 10, pick = 6
     * 输出: 6
     */
    public int guessNumber(int n) {
        if(n == 1) return 1;
        int left = 1;
        int right = n;
        int mid;
        while (left<=right){
            mid = left+(right-left)/2;
            if(guess(mid) == 0) return mid;
            if(guess(mid) == 1) left = mid+1;
            if(guess(mid) == -1) right = mid-1;
        }
        return 0;
    }
}
