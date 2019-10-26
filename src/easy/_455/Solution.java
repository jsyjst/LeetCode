package easy._455;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/26
 *     desc   :
 * </pre>
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;
        if(gLen == 0||sLen == 0) return 0;
        Arrays.sort(g); //从小到大排列
        Arrays.sort(s);//从小到大排列
        int i = gLen-1;
        int j = sLen-1;
        int res = 0;
        while (i>=0&&j>=0){
            if(s[j]>=g[i]){
                j--;
                res++;
            }
            i--;

        }
        return res;
    }
}
