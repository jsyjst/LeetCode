package medium._365;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/20
 *     desc   : 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *     如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *     你允许：装满任意一个水壶
 *     清空任意一个水壶
 *     从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * </pre>
 */
public class Solution {
    /**
     * 输入: x = 3, y = 5, z = 4
     * 输出: True
     *
     * 输入: x = 2, y = 6, z = 5
     * 输出: False
     */

    //先把问题转化为z=ax+by(其中，a,b为整数，表示a,b也有可能是负数)
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == z||y==z||x+y==z) return true;
        if(x==0||y==0) return x+y==z;
        if(x+y<z) return false;
        return z%gcd(x,y)==0;
    }
    //最大公约数
    private int gcd(int x,int y){
        if(x>y){
            int temp = x;
            x = y;
            y = temp;
        }
        while (y%x!=0){
            int temp = x;
            x = y%x;
            y = temp;
        }
        return x;
    }
}
