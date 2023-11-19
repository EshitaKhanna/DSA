/*
 * 2119. A Number After a Double Reversal
 * https://leetcode.com/problems/a-number-after-a-double-reversal/description/
*/

package DSA.Leetcode;

public class NumberAfterDoubleReversal {
    public static boolean isSameAfterReversals(int num) {
        if(num == 0){
            return true;
        }
        int lastDigit = num%10;
        if(lastDigit == 0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(100));
    }
}
