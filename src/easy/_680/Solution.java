package easy._680;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/24
 *     desc   : 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * </pre>
 */
public class Solution {
    public boolean validPalindrome(String s) {
        if(s.length()==1) return true;
        int left = 0;
        int right = s.length()-1;
        char[] c = s.toCharArray();
        while (left<right){
            if(c[left]!=c[right]){
                return isValidate(c,left+1,right)||isValidate(c,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValidate(char[] c,int i,int j){
        while (i<j){
            if(c[i]!=c[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
