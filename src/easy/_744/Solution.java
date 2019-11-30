package easy._744;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/11/30
 *     desc   :
 * </pre>
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int minIndex = Integer.MAX_VALUE;
        char res='a';
        for (char c:letters) {
            if(c-target<0&&26-(target-c)<minIndex){
                minIndex = 26-(target-c);
                res = c;
            }else if(c-target>0&&c-target<minIndex){
                minIndex = c-target;
                res = c;
            }
        }
        return res;

    }
}
