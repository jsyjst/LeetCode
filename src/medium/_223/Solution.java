package medium._223;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/08/20
 *     desc   : 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *     每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 *
 *     说明: 假设矩形面积不会超出 int 的范围。
 * </pre>
 */
public class Solution {
    /**
     * 输入: -3, 0, 3, 4, 0, -1, 9, 2
     * 输出: 45
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int height,width;
        if(E>=C||G<=A) {
            width = 0;
        }else {
            width = Math.min(G,C)-Math.max(E,A);
        }
        if(F>=D||H<=B) {
            height = 0;
        }else {
            height = Math.min(D,H)-Math.max(F,B);
        }
        return (C-A)*(D-B)+(G-E)*(H-F)-width*height;
    }
}
