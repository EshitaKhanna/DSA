/*
 * 896. Monotonic Array
 * https://leetcode.com/problems/monotonic-array/description/
*/

package DSA.Leetcode;

public class MonotoicArray {
    public static boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] < nums[i]){
                decreasing = false;    
                
            }   
            else if(nums[i-1] > nums[i]){
                increasing = false;    
                
            }    
            if(!increasing && !decreasing){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        System.out.println(isMonotonic(nums));
    }
}
