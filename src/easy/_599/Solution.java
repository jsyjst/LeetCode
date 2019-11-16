package easy._599;

import java.util.*;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/11/16
 *     desc   :
 * </pre>
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> resList = new ArrayList<>();
        if(list1.length == 0||list2.length == 0) return resList.toArray(new String[0]);
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        int minIndexSum = Integer.MAX_VALUE;
        for (int i = 0; i <list2.length ; i++) {
            String list = list2[i];
            if(map.containsKey(list)){
                if(map.get(list)+i<minIndexSum){
                    resList.clear();
                    resList.add(list);
                    minIndexSum = map.get(list)+i;
                }else if(map.get(list)+i==minIndexSum){
                    resList.add(list);
                }
            }
        }
        return resList.toArray(new String[resList.size()]);
    }
}
