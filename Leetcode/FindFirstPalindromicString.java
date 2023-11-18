/*
 * 2108. Find First Palindromic String in the Array
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
*/

package DSA.Leetcode;

public class FindFirstPalindromicString{
    public static String firstPalindrome(String[] words) {
        for(int i=0; i<words.length; i++){
          String word = words[i];
          boolean valid = isPalindrome(word);
          if(valid){
            return word;
          }

        }
        return "";
    }

    public static boolean isPalindrome(String word){
          int start =0;
          int end = word.length()-1;
          while(start<end){
            if(word.charAt(start) != word.charAt(end)){
                return false;
            }
            else{
                start++;
                end--;
            }
          }
          return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));
    }

}
