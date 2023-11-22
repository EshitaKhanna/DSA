/*
 * 34. Find First and Last Position of Element in Sorted Array
 *https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
*/

package DSA.Leetcode;

import java.util.ArrayList;

public class FirstAndLastPositionOfElement {
    public static int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean flag = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                arr.add(i);
                flag = true;
            }
        }
        if(flag){
            int ans[] = new int[2];
            ans[0] = arr.get(0);
            ans[1] = arr.get(arr.size()-1);
            return ans;
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        for(int i : searchRange(nums, 6)){
            System.out.println(i);
        }
    }
}
