package swordOffer._8二进制中1的个数;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/13
 *     desc   :
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        System.out.println(NumberOf1(-1));
    }

    public static int NumberOf1(int n) {
        if(n == 0) return 0;
        int res = 0;
        while(n != 0){
            if((n&1) == 1) res++;
            n>>>=1;
        }
        return res;
    }

}
