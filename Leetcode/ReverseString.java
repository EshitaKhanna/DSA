/*
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/description/
*/

package DSA.Leetcode;

public class ReverseString {
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        while(start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start ++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] ch = {'h','e','l','l','o'};
        reverseString(ch);
        for(char c: ch){
            System.out.println(c);
        }

    }
}
