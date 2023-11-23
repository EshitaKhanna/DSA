/*
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/description/
*/

package DSA.Leetcode;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int start =0;
        int end = nums.length-1;
    
        while(start<=end){
            if(nums[start] == val){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
            }
            else{
                start++;
            }
            
        }
        return start;
        
    }
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        System.out.println(removeElement(arr, 3));
    }
}
