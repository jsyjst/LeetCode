package swordOffer._22字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * <pre>
 *     author : jsyjst
 *     time   : 2019/12/23
 *     desc   :
 * </pre>
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str.length() == 0) return res;
        char[] c = str.toCharArray();
        Arrays.sort(c);
        boolean[] visited = new boolean[str.length()];
        LinkedHashSet<String> set = new LinkedHashSet<>();
        helper(set,new StringBuilder(),visited,c);
        res.addAll(set);
        return res;
    }

    private void helper(LinkedHashSet<String> set,StringBuilder res,boolean[] visited,char[] c){
        if(c.length == res.length()){
            set.add(res.toString());
            return;
        }
        for(int i = 0; i < c.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            res.append(c[i]);
            helper(set,res,visited,c);
            visited[i] = false;
            res.deleteCharAt(res.length()-1);
        }
    }
}
