package medium._495;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/07
 *     desc   :
 * </pre>
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            int k = timeSeries[i+1]-timeSeries[i];
            if(k>duration){
                sum+=duration;
            }else {
                sum+=k;
            }
        }
        return sum+duration;
    }
}
