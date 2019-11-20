package easy._657;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/20
 *     desc   :
 * </pre>
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0,y=0;
        for(char c:moves.toCharArray()){
            if(c=='L'){
                x--;
            }else if(c=='R'){
                x++;
            }else if(c=='U'){
                y++;
            }else if(c=='D'){
                y--;
            }
        }
        return x==0&&y==0;
    }
}
