/*
 * 1758. Minimum Changes To Make Alternating Binary String
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/
*/
package DSA.Leetcode;

public class MinChangesToMakeAlternatingBinaryString {
    public static int minOperations(String s) {
        int count1 = 0;
        int count2 = 0;
        if(s.length() == 1){
            return 0;
        } 
 
        for(int i=0; i<s.length(); i++){
 
            // case 1
             if(i%2 == 0 && s.charAt(i) == '1'){
                 count1++;
             }else if(i%2 == 1 && s.charAt(i) == '0'){
                 count1++;
             }
 
            //case 2
 
             if(i%2 == 0 && s.charAt(i) == '0'){
                 count2++;
             }else if(i%2 == 1 && s.charAt(i) == '1'){
                 count2++;
             }
        }
 
        return Math.min(count1, count2);
    }

    public static void main(String[] args) {
        System.out.println(minOperations("0100"));
    }
}
