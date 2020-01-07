package swordOffer._24整数中1出现的次数;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/01/07
 *     desc   :
 * </pre>
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;

        //当前位
        int i = 1;
        int cur = 0,after =0,before = 0;
        while((n / i)!= 0){
            //当前位
            cur = (n / i) % 10;
            //高一位
            before = n / (i * 10);
            //低一位
            after = n - (n / i) * i;

            if(cur == 0){
                res += before * i;
            }else if(cur == 1){
                res += before * i + after + 1;
            }else {
                res += (before + 1) * i;
            }

            //移动
            i *= 10;
        }
        return res;

    }
}
