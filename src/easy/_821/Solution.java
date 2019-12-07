package easy._821;

import java.util.ArrayList;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/07
 *     desc   :
 * </pre>
 */
public class Solution {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] res = new int[len];
        int pre = -10000;
        for (int i = 0; i < len; i++) {
            if(S.charAt(i) == C) pre = i;
            res[i] = i-pre;
        }
        pre =10000;
        for (int i = len-1; i >=0; i--) {
            if(S.charAt(i) == C) pre = i;
            res[i] = Math.min(pre-i,res[i]);
        }
        return res;

    }
}
