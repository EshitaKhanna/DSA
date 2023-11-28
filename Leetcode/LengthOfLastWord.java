/*
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/description/
*/

package DSA.Leetcode;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int count = 0;
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch != ' '){
                count ++;
            }
            if(count>0 && ch==' ') {
                break;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }
}
