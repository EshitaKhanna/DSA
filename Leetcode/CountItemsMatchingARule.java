/*
 * 1773. Count Items Matching a Rule
 * https://leetcode.com/problems/count-items-matching-a-rule/description/
*/
package DSA.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingARule {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(int i=0; i<items.size(); i++){
            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)){
                count ++;
            }
            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)){
                count ++;
            }
            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();

        items.add(Arrays.asList("phone","blue","pixel"));
        items.add(Arrays.asList("computer","silver","lenovo"));
        items.add(Arrays.asList("phone","gold","iphone"));

        System.out.println(countMatches(items, "color", "silver"));
    }
}
