/*
 * 2942. Find Words Containing Character
 * https://leetcode.com/problems/find-words-containing-character/description/
*/

package DSA.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            String s = words[i];
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == x){
                    arr.add(i);
                    break;
                }
            }
            
        }
        return arr;
    }

    public static void main(String[] args) {
        String[] words = {"leet","code"};
        for(int i: findWordsContaining(words, 'e')){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
