/*
 * 1859. Sorting the Sentence
 * https://leetcode.com/problems/sorting-the-sentence/description/
*/
package DSA.Leetcode;

public class SortingTheSentence {
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];

        for(String word: words){
            int pos = word.charAt(word.length() -1) - '0';
            String str = word.substring(0, word.length()-1);
            
            ans[pos-1] = str;
        }

        return String.join(" ", ans);
    }

    public static void main(String[] args){
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
}
