/*
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
*/

package DSA.Leetcode;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int x){
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == x){
                return mid;
            }else if(x>nums[mid]){
                return binarySearch(nums, mid+1, end, x);
            }else{
                return binarySearch(nums, start, mid-1, x);
            }
        }
        return start;
    }

    public static void main(String[] args){
        int[] arr = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(arr, target));
    }
}
