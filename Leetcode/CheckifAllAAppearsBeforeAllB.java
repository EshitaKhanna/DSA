/*
 * 2124. Check if All A's Appears Before All B's
 * https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/description/
*/

package DSA.Leetcode;

public class CheckifAllAAppearsBeforeAllB{
    public static boolean checkString(String s) {
        
        for(int i=0; i<s.length(); i++){
            if(s.contains("ba")){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(checkString(s));
    }
}