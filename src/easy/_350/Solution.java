package easy._350;

import java.util.HashMap;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/18
 *     desc   : 给定两个数组，编写一个函数来计算它们的交集。
 * </pre>
 */
public class Solution {
    /**
     *输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     *
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> commonMap = new HashMap<>();
        for(int num:nums1){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            map.put(num,map.get(num)+1);
        }
        int len = 0;
        for(int num:nums2){
            if(map.containsKey(num)&&map.get(num)!=0){
                len++;
                map.put(num,map.get(num)-1);
                if(!commonMap.containsKey(num)){
                    commonMap.put(num,0);
                }
                commonMap.put(num,commonMap.get(num)+1);
            }
        }
        int[] res = new int[len];
        int i = 0;
        for(int key:commonMap.keySet()){
            int k = commonMap.get(key);
            while (k--!=0){
                res[i++] = key;
            }
        }
        return res;
    }
}
