package easy._754;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/04
 *     desc   :
 * </pre>
 */
public class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
        int sum = 0;
        int res =1;
        while (target >sum||(sum-target)%2!=0){
            sum+=res++;
        }
        return res-1;
    }
}
