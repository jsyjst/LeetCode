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
                String s = scanner.nextLine();
                StringBuilder builder = new StringBuilder();
                int repeat = 1;
                int isAA = 0;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (i != 0 && c == builder.charAt(builder.length() - 1)) {
                        repeat++;
                    } else {
                        if (isAA > 1) isAA--;
                        repeat = 1;
                    }
                    //如果是AAA型，则跳过该次循环
                    if (repeat == 3) {
                        repeat--;
                        continue;
                        //如果是AABB型，也跳过该次循环
                    } else if (repeat == 2) {
                        if (isAA != 0) {
                            repeat--;
                            continue;
                        } else {
                            isAA++;
                        }
                    }
                    builder.append(c);
                }
                System.out.println(builder.toString());
            }
        }
    }
        public static ArrayList recover ( int n, String[] Strings){
            ArrayList<String> res = new ArrayList<>();
            if (n == 0) return res;
            for (String s : Strings) {
                StringBuilder builder = new StringBuilder();
                int repeat = 1;
                int isAA = 0;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (i != 0 && c == builder.charAt(builder.length() - 1)) {
                        repeat++;
                    } else {
                        if (isAA > 1) isAA--;
                        repeat = 1;
                    }
                    //如果是AAA型，则跳过该次循环
                    if (repeat == 3) {
                        repeat--;
                        continue;
                        //如果是AABB型，也跳过该次循环
                    } else if (repeat == 2) {
                        if (isAA != 0) {
                            repeat--;
                            continue;
                        } else {
                            isAA++;
                        }
                    }
                    builder.append(c);
                }
                res.add(builder.toString());
            }
            return res;
        }
    }


