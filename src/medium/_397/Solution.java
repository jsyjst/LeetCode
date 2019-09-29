package medium._397;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/29
 *     desc   : 给定一个正整数 n，你可以做如下操作:
 *     1. 如果 n 是偶数，则用 n / 2替换 n。
 *     2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 *     n 变为 1 所需的最小替换次数是多少？
 * </pre>
 */
public class Solution {
    public int integerReplacement(int n) {
        if(n <= 3) return n-1;
        int res = 0;
        while (n!=1){
            //偶数,xxxx xxx0
            if((n&1) == 0){
                n>>>=1;
                res++;
            }else {
                //判断是xxxx xx01还是xxxx xx11
                if((n&2)==0){
                    n--;
                }else {
                    //3比较特殊
                    if(n==3) {
                        res+=2;
                        break;
                    }else {
                        n++;
                    }

                }
                res++;
            }
        }
        return res;

    }
}
