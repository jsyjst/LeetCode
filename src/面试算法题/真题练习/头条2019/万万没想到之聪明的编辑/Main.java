package 面试算法题.真题练习.头条2019.万万没想到之聪明的编辑;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2020/02/27
 *     desc   :
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = Integer.valueOf(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(scanner.nextLine());
                for(int j = 2; j < sb.length();j++){
                    //AAA型的
                    if(sb.charAt(j) == sb.charAt(j - 1) && sb.charAt(j) == sb.charAt(j - 2)){
                        sb.deleteCharAt(j);
                        j--;
                        //AABB型的
                    }else if(j > 2 && sb.charAt(j-3) == sb.charAt(j-2) && sb.charAt(j-1) == sb.charAt(j)){
                        sb.deleteCharAt(j);
                        j--;
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}



