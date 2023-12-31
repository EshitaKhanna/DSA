package DSA.Leetcode;

import java.util.HashMap;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;

        
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
