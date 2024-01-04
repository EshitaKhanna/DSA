/*
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
*/
package DSA.Leetcode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        
        int[] arr = new int[nums.length];
        int index = 0;

        for (int i = nums.length - k; i < nums.length; i++) {
            arr[index] = nums[i];
            index++;
        }
        for (int i = 0; i < nums.length - k; i++) {
            arr[index] = nums[i];
            index++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }  
}
