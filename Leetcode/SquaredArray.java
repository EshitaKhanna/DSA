/*
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
*/

package DSA.Leetcode;

import java.util.Arrays;

public class SquaredArray {
     public static int[] sortedSquares(int[] nums) {
        int[] squared = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            squared[i] = nums[i] * nums[i];
        }
        Arrays.sort(squared);
        return squared;
    }
    
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] ans = sortedSquares(nums);
        for(int i: ans){
            System.out.println(i);
        }
    }
}
