package swordOffer._6旋转数组的最小数字;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/12
 *     desc   :
 * </pre>
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 1};
        System.out.println(minNumberInRotateArray(array));
    }

    static int res = 0;

    public static int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) return 0;
        binarySearch(array, 0, len - 1);
        return res == 0 ? array[0] : res;
    }

    public static void binarySearch(int[] array, int left, int right) {
        if (left >right) return;
        int mid = left + (right - left) / 2;
        if (0 <= mid - 1 && array[mid] < array[mid - 1]) {
            res = array[mid];
            return;
        }
        binarySearch(array, left, mid - 1);
        binarySearch(array, mid + 1, right);
    }
}
