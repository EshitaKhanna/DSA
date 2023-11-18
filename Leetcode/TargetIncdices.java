/*
 * 2089. Find Target Indices After Sorting Array
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/description/
*/

package DSA.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TargetIncdices {
    public static List<Integer> targetIndices(int[] nums, int target) {
       Arrays.sort(nums); 
       List<Integer> list = new ArrayList<Integer>();
       for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        Collections.sort(list);   
       return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,2,3};
        for(int i: targetIndices(arr, 2)){
            System.out.println(i);
        }
    }
}
