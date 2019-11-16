package easy._605;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/16
 *     desc   : 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *     给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
 *     能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * </pre>
 */
public class Solution {
    /**
     * 输入: flowerbed = [1,0,0,0,1], n = 1
     * 输出: True
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(n==0) return true;
        if(n>(len+1)/2) return false;
        if(len==1) return flowerbed[0]==0;
        if(flowerbed[0]==0&&flowerbed[1]==0){
            n--;
            flowerbed[0]=1;
        }
        for (int i = 1; i < len-1; i++) {
            if(flowerbed[i-1]==0&&flowerbed[i]==0&&flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
            if(n==0) return true;
        }
        if(flowerbed[len-1]==0&&flowerbed[len-2]==0) n--;
        return n==0;

    }
}
