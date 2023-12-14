/*
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
*/
package DSA.Leetcode;

public class MoveZeros{
    public static void moveZeroes(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[index] = nums[i]; // shift non zero ele to beginning
                index++;
            }
        }

        while(index < nums.length){
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int i: nums){
            System.out.print(i + " ");
        }
    }
}