package medium._486;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/04
 *     desc   : 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，
 *     然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *     给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * </pre>
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length <=1) return true;
        int sum1 = 0;//玩家一的分数
        int sum2 = 0;//玩家二的分数
        int count = 2;//次数
        LinkedList<Integer> numList = new LinkedList<>();
        //添加到List集合中，容易删除
        for(int num:nums) numList.add(num);
        //添加策略，1号玩家总是拿端点最大的数，2号玩家拿端点最小的数
        while (!numList.isEmpty()){
            int first = numList.getFirst();
            int last = numList.getLast();
            if(count%2==0){
                if(first>=last){
                    sum1+=first;
                    numList.removeFirst();
                }else {
                    sum1+=last;
                    numList.removeLast();
                }
            }else {
                if(first<last){
                    sum1+=first;
                    numList.removeFirst();
                }else {
                    sum1+=last;
                    numList.removeLast();
                }
            }
            count++;

        }
        return sum1>=sum2;
    }
}
