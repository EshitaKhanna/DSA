/*
 * 201. Bitwise AND of Numbers Range
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
*/
package DSA.Leetcode;

public class BitwiseANDofNumbers {
    public int rangeBitwiseAnd(int left, int right) {
        // int ans = left;
        // for(int i=left+1; i<=right; i++){
        //     ans = ans & i;
        // }
        // return ans;

        int count = 0;

        while(left != right){
            left >>=1;
            right >>=1;
            count++;
        }

        return left << count;
    }
}
