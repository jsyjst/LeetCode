package medium._470;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/30
 *     desc   : 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *     不要使用系统的 Math.random() 方法。
 * </pre>
 */
public class Solution extends SolBase{
    /**
     * 输入: 1
     * 输出: [7]
     *
     * 输入: 2
     * 输出: [8,4]
     *
     * 输入: 3
     * 输出: [8,1,10]
     */
    public int rand10() {
        int res = 40;
        while (res>39){
            res = (rand7()-1)*7+(rand7()-1);//0~48
        }
        //跳出循环,0~39共40个数，等概率
        return res%10+1;
    }
}
