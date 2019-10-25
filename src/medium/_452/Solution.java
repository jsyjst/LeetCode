package medium._452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/25
 *     desc   :
 * </pre>
 */
public class Solution {

    //贪心
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0||points[0].length == 0) return 0;
        //区间排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int end = points[0][1];
        int res = 1;
        for(int[] point:points){
            if(point[0]<=end){
                end = Math.min(end,point[1]);
            }else {
                res++;
                end = point[1];
            }
        }
        return res;
    }
}
