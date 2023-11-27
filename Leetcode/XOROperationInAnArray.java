/*
 * 1486. XOR Operation in an Array
 * https://leetcode.com/problems/xor-operation-in-an-array/description/
*/
package DSA.Leetcode;

public class XOROperationInAnArray {
    public static int xorOperation(int n, int start) {
        int ans = 0;
        int j = 0;
        for(int i=0; i<n; i++){
            ans = ans ^(start + (2*j));
            j++;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }
}
