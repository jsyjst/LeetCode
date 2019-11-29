package easy._717;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/11/28
 *     desc   : 1比特与2比特字符
 * </pre>
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        for (int i = bits.length-2; i >=0; i--) {
            if(bits[i] == 1){
                count++;
            }else {
                break;
            }
        }
        return count==0||count==2;
    }
}
