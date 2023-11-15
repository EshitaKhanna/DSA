/*
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/description/
*/

package DSA.Leetcode;

public class RunningSum {
    public static int[] runningSum(int[] nums) {
        
        for(int i=1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }

        return nums;
    }

    public static void main (String []args){
        int []arr = {1,2,3,4};
        int[] output = runningSum(arr);
        for(int i: output){
            System.out.println(i);
        }

    }
    
}
