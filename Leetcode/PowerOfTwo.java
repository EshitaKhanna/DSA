/*
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/description/
*/
package DSA.Leetcode;

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        for(int i=0; i<=31; i++){
            if(n== Math.pow(2,i)){
                return true;
            }
        }
        return false;
     }

     public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
     }
}
