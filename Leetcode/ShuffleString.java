/*
 * 1528. Shuffle String
 * https://leetcode.com/problems/shuffle-string/description/
*/
package DSA.Leetcode;

public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        char[] str = new char[s.length()];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            str[indices[i]] = ch;
        }
        String res = new String(str);
        return res;

    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] index = {4,5,6,7,0,2,1,3};

        System.out.println(restoreString(s, index));
    }
}
