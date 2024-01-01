/*
 * 2367. Number of Arithmetic Triplets
 * https://leetcode.com/problems/number-of-arithmetic-triplets/description/
*/
package DSA.Leetcode;

public class NumberOfArithmeticTriplets {
    public static int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
           for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(i<j && j<k && nums[j] - nums[i] == diff && nums[k] - nums[j] == diff){
                        count ++; 
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []nums = {0,1,4,6,7,10};
        System.out.println(arithmeticTriplets(nums, 3));
    }
}
