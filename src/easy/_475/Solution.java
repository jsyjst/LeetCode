package easy._475;

import java.util.Arrays;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/01
 *     desc   :
 * </pre>
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int i = 0;
        for(int house:houses){
            //找到房子右边的供暖器
            while (i<heaters.length&&heaters[i]<house){
                i++;
            }
            //该房子左边没有供暖器，右边有供暖器，则选择右边的供暖器取暖
            if(i == 0){
                res = Math.max(res,heaters[i]-house);
            }else if(i == heaters.length){//该房子没有右边的供暖器，则选择左边供暖器取暖
                res = Math.max(res,house-heaters[i-1]);
            }else {//取右边供暖器到房子的距离和左边供暖器到房子距离的最小值
                res = Math.max(res,Math.min(house-heaters[i-1],heaters[i]-house));
            }
        }
        return res;
    }
}
