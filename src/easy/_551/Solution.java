package easy._551;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/13
 *     desc   : 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *     'A' : Absent，缺勤
 *     'L' : Late，迟到
 *     'P' : Present，到场
 *     如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *     你需要根据这个学生的出勤记录判断他是否会被奖赏。
 * </pre>
 */
public class Solution {
    /**
     * 输入: "PPALLP"
     * 输出: True
     *
     * 输入: "PPALLL"
     * 输出: False
     */
    public boolean checkRecord(String s) {
        int len =s.length();
        if(len<=1) return true;
        int aCount = 0;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)=='A') aCount++;
            if(aCount>1) return false;
            if(i<len-2&&s.charAt(i)=='L'&&s.charAt(i+1)=='L'&&s.charAt(i+2)=='L') return false;
        }
        return true;
    }
}
