/*
 * 796. Rotate String
 * https://leetcode.com/problems/rotate-string/description/
*/
package DSA.Leetcode;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length() || s==null || goal==null){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            if(rotate(s,i).equals(goal)){
                return true;
            }
        }

        return false;

    }

    private static String rotate(String s, int index){
        int len = s.length();
        char[] rotated = new char[len];

        for (int i = 0; i <len; i++) {
            int newIndex = (i + index) % len;
            if (newIndex < 0) {
                newIndex += len; 
            }
            rotated[newIndex] = s.charAt(i);
        }

        return new String(rotated);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "bcdea";

        System.out.println(rotateString(s, goal));
    }
}
