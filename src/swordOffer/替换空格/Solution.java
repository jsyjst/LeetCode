package swordOffer.替换空格;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/10
 *     desc   : 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *     例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * </pre>
 */
public class Solution {

    public static void main(String [] args){
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        return s.replaceAll(" ","%20");
    }
}
