package medium._307;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/06
 *     desc   : 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *     update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * </pre>
 */
public class NumArray {
    /**
     * Given nums = [1, 3, 5]
     * sumRange(0, 2) -> 9
     * update(1, 2)
     * sumRange(0, 2) -> 8
     * <p>
     * 说明:数组仅可以在 update 函数下进行修改。
     * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
     */
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public void update(int i, int val) {
        int n = val - (sums[i + 1] - sums[i]);
        for (int j = i + 1; j < sums.length; j++) {
            sums[j] += n;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }

}
