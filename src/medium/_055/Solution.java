package medium._055;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/06/07
 *     desc   : 给定一个非负整数数组，你最初位于数组的第一个位置。
 *              数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *              判断你是否能够到达最后一个位置。
 * </pre>
 */
public class Solution {
    /**
     *示例 1:
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
     *
     * 示例 2:
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     */

    public static void main(String[] args) {
        int[] nums = {2,3,2,7,8};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        return backtrack(nums,0);
    }

    /**
     * 回溯法，比较耗时,超出时间限制
     * @param nums 数组
     * @param index 位置
     * @return 是否能够达到
     */
    private static boolean backtrack(int[] nums, int index){
        if(index == nums.length -1 || index + nums[index] >= nums.length-1) return true;
        if(index > nums.length-1||nums[index]== 0) return false;
        for (int i = nums[index]; i >= 1; i--) {
            if(backtrack(nums,index+i)){
                return true;
            }
        }
        return false;
    }

    /**
     * 自顶向上的备忘录的动态规划方法，通过
     */
    public static boolean canJumpTopToDown(int[] nums) {
        if(nums.length == 1) return true;
        int[] memory = new int[nums.length];
        for (int i = 0; i < memory.length ; i++) {
            memory[i] = -1;
        }
        return TopToDown(nums,memory,0);
    }

    private static boolean TopToDown(int[] nums,int [] memory,int index){
        if(memory[index] != -1){
            return memory[index] == 1;
        }
        if(index == nums.length -1 || index + nums[index] >= nums.length-1) {
            memory[index] = 1;
            return true;
        }
        if(index > nums.length-1||nums[index]== 0) {
            memory[index] = 0;
            return false;
        }
        for (int i = nums[index]; i >= 1; i--) {
            if(TopToDown(nums,memory,index+i)){
                memory[index] = 1;
                return true;
            }
        }
        memory[index] = 0;
        return false;
    }
    /**
     * 自底向上的动态规划
     */
    public static boolean canJumpDownToTop(int[] nums) {
        if(nums.length == 1) return true;
        int[] memory = new int[nums.length];
        for (int i = 0; i < memory.length -1 ; i++) {
            memory[i] = -1;
        }
        memory[nums.length-1] = 1;
        for (int i = nums.length-2; i>=0; i--) {
            for (int j = i+nums[i]; j > 0; j--) {
                if(j >= nums.length-1||memory[j] == 1){
                    memory[i] = 1;
                    break;
                }
            }
        }
        return memory[0] == 1;
    }
    /**
     * 贪心，时间复杂度最优解
     */
    public boolean canJumpBest(int[] nums) {
        if(nums.length == 1) return true;
        int reachableIndex = nums.length-1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(i + nums[i] >= reachableIndex){
                reachableIndex = i;
            }
        }
        return reachableIndex==0;
    }

}
