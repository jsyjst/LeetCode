package easy._748;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/02
 *     desc   :
 * </pre>
 */
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int index = 0;
        int len = 16;
        //26个字母的计数
        int[] count = new int[26];
        for(char c:licensePlate.toCharArray()){
            if(c >= 'a' && c <= 'z')
                count[c - 'a']++;
            else if(c >= 'A' && c <= 'Z')
                count[c - 'A']++;
        }
        for (int i = 0; i < words.length; i++) {
            int[] temp = new int[26];
            for(char c:words[i].toCharArray()){
                if(c >= 'a' && c <= 'z')
                    temp[c - 'a']++;
                else if(c >= 'A' && c <= 'Z')
                    temp[c - 'A']++;
            }
            boolean isBreak = false;
            for (int j = 0; j < 26; j++) {
                if(count[j]>temp[j]) {
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak&&words[i].length()<len){
                len = words[i].length();
                index = i;
            }

        }
        return words[index];

    }
}
