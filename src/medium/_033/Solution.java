package medium._033;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/05/25
 *     desc   :假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *     ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *     搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *     你可以假设数组中不存在重复的元素。
 *     你的算法时间复杂度必须是 O(log n) 级别。
 * </pre>
 */
public class Solution {
    /**
     * 示例 1:
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     *
     * 示例 2:
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     */
    public int search(int[] nums, int target) {
        return binSearch(nums,target,0,nums.length-1);
    }

    /**
     * 7 个月前
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
     * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。
     * 就这样循环.
     * @param nums 数组
     * @param target 目标值
     * @param low 最低位
     * @param high 最高位
     * @return 不存在返回-1
     */
    public int binSearch(int[] nums,int target,int low,int high){
        int mid = (low+high)/2;
        if(low > high) return -1;
        if(nums[mid]== target){
            return mid;
        }else if(nums[mid]>=nums[low]){//有序情况
            if(nums[mid]>target&&target>nums[low] ){ //左边有序并且target值在左边
                return binSearch(nums,target,low,mid-1);
            }else {
                return binSearch(nums,target,mid+1,high);
            }
        }else{//无序情况下
            if(nums[mid]<target&&target<nums[high]){ //右边有序并且，target值在右边
                return binSearch(nums,target,mid+1,high);
            }else {
                return binSearch(nums,target,low,mid-1);
            }
        }
    }


    /**
     * 常规二分查找递归实现
     * @param nums 数组
     * @param target 目标值
     * @param low 最低位
     * @param high 最高位
     * @return 找不到返回-1
     */
    public static int binarySearch(int[] nums,int target,int low,int high){
       // int mid = (low+high)/2; 这句语句有可能造成溢出，比如low跟high都很大，两者相加有可能溢出
        int mid = low+(high-low)/2;
        if(target == nums[mid]){
            return mid;
        }
        if(low > high) {
            return -1;
        } else if(target < nums[mid]){
            return binarySearch(nums,target,low,mid-1);
        }else if(target > nums[mid]){
            return binarySearch(nums,target,mid+1,high);
        }
        return -1;
    }

    /**
     * 常规非递归实现二分查找
     * @param nums 数组
     * @param key 关键字
     * @return 不存在返回-1
     */
    public static int binarySearch(int []nums,int key){
        int mid;
        int low = 0;
        int high = nums.length-1;
        while (low<= high){
            mid = (high+low)/2;
            if(key == nums[mid]){
                return mid;
            }else if(key > nums[mid]){
                low = mid +1;
            }else if(key < nums[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }

}
