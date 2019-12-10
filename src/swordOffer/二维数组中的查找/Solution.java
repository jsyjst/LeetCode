package swordOffer.二维数组中的查找;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/10
 *     desc   : 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *     请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * </pre>
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int rowLen = array.length;
        if(rowLen == 0) return false;
        int rankLen = array[0].length;
        if(rankLen == 0) return false;
        int i = 0;
        int j = rankLen - 1;
        while(i < rowLen && j >= 0){
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] < target){
                i++;
            }else{
                j--;
            }

        }
        return false;
    }
}
