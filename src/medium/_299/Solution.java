package medium._299;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/03
 *     desc   : 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
 *     每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
 *     有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 *     请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 *     请注意秘密数字和朋友的猜测数都可能含有重复数字。
 * </pre>
 */
public class Solution {
    /**
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     * <p>
     * 输入: secret = "1123", guess = "0111"
     * 输出: "1A1B"
     * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
     */
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[] count = new int[10];//secret和guess只含有数字

        //统计正确字符串各数字出现的次数
        for (int i = 0; i < secret.length(); i++) {
            count[s[i] - '0']++;
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                A++;
                count[s[i] - '0']--;
                if(count[s[i] - '0']<0) B--;
            } else if (count[g[i] - '0'] > 0) {
                B++;
                count[g[i] - '0']--;
            }

        }
        return A+"A"+B+"B";
    }
}
