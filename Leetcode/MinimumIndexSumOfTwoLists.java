/*
 * 599. Minimum Index Sum of Two Lists
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
*/
package DSA.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumOfTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i=0; i<list1.length; i++){
            map.put(list1[i], i);
        }

        List<String> s = new ArrayList<>();
        for(int i=0; i<list2.length; i++){
            String str = list2[i];
            if(map.containsKey(str)){
                int sum = map.get(str) + i;
                if(sum < min){
                    min = sum;
                    s.clear();
                    s.add(str);
                }else if(min == sum){
                    s.add(str);
                }
            }
        }

        return s.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String list1[] = {"Shogun","Tapioca Express","Burger King","KFC"};
        String list2[] = {"KFC","Shogun","Burger King"};

        for(String i: findRestaurant(list1, list2)){
            System.out.println(i);
        }
    }
}
