package medium._093;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/07
 *     desc   : 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * </pre>
 */
public class Solution {
    /**
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     */
    //暴力法
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12||s.length()<4) return res;
        for (int i = 1; i <= 3; i++) {
            for (int j = i+1; (j <= i+4&&j<s.length()-1); j++) {
                for (int k = j+1; (k <= j+4&&k<s.length()); k++) {
                    String temp1 = s.substring(0,i);
                    String temp2 = s.substring(i,j);
                    String temp3 = s.substring(j,k);
                    String temp4 = s.substring(k);
                    if(isValid(temp1)&&isValid(temp2)&&isValid(temp3)&&isValid(temp4)){
                        res.add(temp1+"."+temp2+"."+temp3+"."+temp4);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String temp){
        return temp.length() <= 3 && (temp.charAt(0) != '0' || temp.length() == 1) && Integer.valueOf(temp) <= 255;
    }
}
