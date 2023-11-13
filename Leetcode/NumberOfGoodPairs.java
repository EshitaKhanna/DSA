/*
 * 2824. Count Pairs Whose Sum is Less than Target
 * https://leetcode.com/problems/number-of-good-pairs/description/
*/

package DSA.Leetcode;

public class NumberOfGoodPairs{
    public static int numIdenticalPairs(int[] nums) {

        int count = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(i<j && nums[i] == nums[j]){
                    count ++;
                }
            }

        }

        return count;
        
    }
    public static void main(String[] args){

        int [] arr = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(arr)); // output = 4

    }
}