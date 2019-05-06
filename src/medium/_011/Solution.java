package medium._011;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/06
 *     desc   : 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 *             在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 *             找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * </pre>
 */
public class Solution {
    /**
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     */

    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int area = 0;
        while (left != right){
            area = Math.max(area,area(height,left,right));
            //如果左边的高比右边的低，则移动左边的位置
            if(height[left] < height[right]){
                left++;
            } else{
                //否则移动右边的位置
                right--;
            }
        }
        return area;
    }


    /**
     * 计算面积
     * @param heights 数组
     * @param left 左边的位序
     * @param right 右边的位序
     * @return 面积
     */
    public static int area(int[] heights,int left,int right){
        int width = right - left;
        int height = Math.min(heights[left],heights[right]);
        return width*height;
    }

}
