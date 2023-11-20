/*
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
*/


package DSA.Leetcode;

public class SearchInRotatedSortedArray {
     public static int search(int[] nums, int target) {
        
        for(int i=0 ; i<nums.length; i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
	}
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }
}
