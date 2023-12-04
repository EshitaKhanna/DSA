/*
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
*/

package DSA.Leetcode;

public class HowManyNumbersAreSmallerThanTheCurrNum {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[nums.length];
        for(int i=0; i<count.length; i++){
            count[i] = 0;
        }
        for(int i=0; i<nums.length; i++){
            for(int j= 0; j<nums.length; j++){
                if(j!=i && nums[j] < nums[i] && nums[i] != nums[j]){
                    count[i] ++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {8,1,2,2,3};
        for(int i: smallerNumbersThanCurrent(arr)){
            System.out.print(i +  " ");
        }
    }
}
