/*
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
*/

package DSA.Leetcode;

import java.util.HashMap;

public class Duplicate {
    public static boolean containsDuplicate(int[] nums) {
        /*
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
        */
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i: nums){
            if(freq.containsKey(i)){
                return true;
            }
            freq.put(i, 1);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(arr));
    }
}
