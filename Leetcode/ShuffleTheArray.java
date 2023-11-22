/*
 * 1470. Shuffle the Array
 * https://leetcode.com/problems/shuffle-the-array/description/
*/

package DSA.Leetcode;

public class ShuffleTheArray {
    public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
      
        for(int i=0; i<n; i++){
            ans[2*i] = nums[i];
            ans[2*i + 1] = nums[i+n];
           
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4,7};
        for(int i: shuffle(arr, 3)){
            System.out.println(i);
        }

    }
}
