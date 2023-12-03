/*
 * 136. Single Number
 * https://leetcode.com/problems/single-number/description/
*/
package DSA.Leetcode;

import java.util.HashMap;

public class SingleOne {
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) == 1){
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
}
