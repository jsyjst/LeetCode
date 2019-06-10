package medium._056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/10
 *     desc   : 给出一个区间的集合，请合并所有重叠的区间。
 * </pre>
 */
public class Solution {

    public static void main(String[] args){
        int[][] nums= {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        System.out.println(merge(nums));

    }
    /**
     * 示例 1:
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 示例 2:
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        List<int[]> res = new ArrayList<>();
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        res.add(new int[]{intervals[0][0],intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>res.get(res.size()-1)[1]){ //如果不可合并，则添加到集合中
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }else {//可合并的话比较大小
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],intervals[i][1]);
            }
        }
        int [][] result = new int[res.size()][2];
        return res.toArray(result);
    }

    /**
     * 优化空间复杂度和时间复杂度
     */
    public static int[][] mergeBetter(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        List<int[]> res = new ArrayList<>();
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int [] resInt = new int[2];
            resInt[0] = intervals[i][0];
            resInt[1] = intervals[i][1];
            while (i<intervals.length-1&&resInt[1]>=intervals[i+1][0]){
                resInt[1] = Math.max(resInt[1],intervals[i+1][1]);
                i++;
            }
            res.add(resInt);
        }
        int[][] result = new int[res.size()][2];
        return res.toArray(result);
    }
}
