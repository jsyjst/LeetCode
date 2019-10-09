package medium._406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/09
 *     desc   : 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
 *     k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * </pre>
 */
public class Solution {
    /**
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     *
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */
    public int[][] reconstructQueue(int[][] people) {

        //按照h降序，k升序的方式排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int[] i:people){
            list.add(i[1],i);
        }
        return list.toArray(new int[list.size()][]);
    }
}
