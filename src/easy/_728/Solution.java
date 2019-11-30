package easy._728;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/11/30
 *     desc   :
 * </pre>
 */
public class Solution {
    /**
     * 输入：
     * 上边界left = 1, 下边界right = 22
     * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right ; i++) {
            int k = i;
            boolean isBreak = false;
            while (k!=0){
                if(k%10==0||i%(k%10)!=0) {
                    isBreak = true;
                    break;
                }
                k/=10;
            }
            if(!isBreak) res.add(i);
        }
        return res;
    }
}
