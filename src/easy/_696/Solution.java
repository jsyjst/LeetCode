package easy._696;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/21
 *     desc   :
 * </pre>
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        if(s.length() == 0) return 0;
        int res = 0;
        int cur = 1,last = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)) {
                cur++;
            }else {
                last = cur;
                cur = 1;
            }
            if(last>=cur) res++;
        }
        return res;
    }
}
