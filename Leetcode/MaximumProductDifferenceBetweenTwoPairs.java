/*
 * 1913. Maximum Product Difference Between Two Pairs
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/
*/

package DSA.Leetcode;

import java.util.Arrays;

public class MaximumProductDifferenceBetweenTwoPairs {
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int start=0;
        int end=nums.length-1;
        
        int ans=(nums[end]*nums[end-1])-(nums[start]*nums[start+1]);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,2,7,4};
        System.out.println(maxProductDifference(nums));
    }
}
