/*
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/
*/

package DSA.Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        /* 
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);

        return Arrays.equals(s_arr, t_arr);
        */

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            
            if(!map.containsKey(ch) || map.get(ch) == 0){
                return false;
            }else{
                map.put(ch, map.get(ch)-1);
            }
        }

        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s,t));
    }
}
