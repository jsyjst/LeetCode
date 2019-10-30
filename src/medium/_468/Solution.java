package medium._468;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/10/30
 *     desc   : 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
 * </pre>
 */
public class Solution {
    /**
     * 输入: "172.16.254.1"
     * 输出: "IPv4"
     * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
     *
     * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * 输出: "IPv6"
     * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
     *
     *
     * 输入: "256.256.256.256"
     * 输出: "Neither"
     * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
     */
    public String validIPAddress(String IP) {
       String[] res = new String[]{"Neither","IPv4","IPv6"};
       if(IP.contains(".")&&IP.contains(":")) return res[0];
       if(IP.length()==0||IP.charAt(IP.length()-1)=='.'||IP.charAt(IP.length()-1)==':') return res[0];
       if(IP.contains(".")){
           String[] v4s = IP.split("\\.");
           System.out.println(v4s.length);
           if(v4s.length!=4) return res[0];
           for (String v4:v4s) {
               System.out.println(v4);
               if(v4.length()==0||v4.charAt(0) == '-') return res[0];
               if(v4.length()!=1&&v4.charAt(0)=='0') return res[0];
               try {
                   int v4Int =Integer.valueOf(v4);
                   System.out.println(v4Int);
                   if(v4Int<0||v4Int>255) return res[0];
               }catch (NumberFormatException e){
                   return res[0];
               }

           }
           return res[1];
       }else {
            String[] v6s = IP.split(":");
           System.out.println(v6s.length);
            if(v6s.length!=8) return res[0];
            for(String v6:v6s){
                if(v6.length()>4||v6.length()==0) return res[0];
                for (char c:v6.toCharArray()) {
                    if(!((c>='0'&&c<='9')||(c>='a'&&c<='f')||(c>='A'&&c<='F'))) return res[0];
                }
            }
            return res[2];
       }
    }
}
