package 排序算法.冒泡;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/24
 *     desc   :
 * </pre>
 */
public class Solution {
    public static void main(String[] args){
        int[] nums = new int[]{5,4,3,2,1};
        bubblingSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]+",");
        }
    }

    public static void bubblingSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            //标志位，当没有交换时，表示所有数已经排好序了
            boolean isChange = false;
            for(int j = 0; j < nums.length - i - 1;j++){
                if(nums[j] > nums[j+1]){
                    isChange = true;
                    //不使用变量来进行交换
                    nums[j] += nums[j+1];
                    nums[j+1] = nums[j] - nums[j+1];
                    nums[j] -= nums[j+1];
                }
            }
            if(!isChange) break;
        }
    }
}
