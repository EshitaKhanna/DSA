/*
 * 2535. Difference Between Element Sum and Digit Sum of an Array
 * https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/
*/ 

package DSA.Leetcode;

public class DiffBetweenElementAndDigitSum {
    public static int differenceOfSum(int[] nums) {
        int ele_sum = 0;
        int dig_sum = 0;

        for(int i: nums){
            ele_sum += i;

            int num = i;
            while (num > 0) {
            dig_sum += num % 10;
            num /= 10;
        }

        }
       
        int abs_sum = Math.abs(ele_sum - dig_sum);
        return abs_sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,15,6,3};
        System.out.println(differenceOfSum(nums));
    }
    
}
