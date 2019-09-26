package medium._386;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/26
 *     desc   : 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * </pre>
 */
public class Solution {
    /**
     * 例如，
     * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
     * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
     */

    //暴力
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                if(s1.length() == s2.length()) return o1-o2;
                int i = 0;
                while (i<s1.length()&&i<s2.length()){
                    if(s1.charAt(i) == s2.charAt(i)) {
                        i++;
                        continue;
                    }
                    return s1.charAt(i)-s2.charAt(i);
                }
                return s1.length()-s2.length();
            }
        });
        return res;
    }

    //更优的解答方法
    public List<Integer> lexicalOrderBest(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(res,n,i);
        }
        return res;
    }

    private void dfs(List<Integer> res,int n,int startNum){
        if(startNum>n) return;
        res.add(startNum);
        for (int i = 0; i < 10; i++) {
            dfs(res,n,startNum*10+i);
        }
    }
}
