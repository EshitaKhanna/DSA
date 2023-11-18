/*
 * 2161. Partition Array According to Given Pivot
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
*/

package DSA.Leetcode;

import java.util.ArrayList;

public class  PartitionArrayAccordingToGivenPivot {

        public static int[] pivotArray(int[] nums, int pivot) {

            ArrayList<Integer> small = new ArrayList<>();
            ArrayList<Integer> equal = new ArrayList<>();
            ArrayList<Integer> large = new ArrayList<>();

            for(int i=0; i<nums.length; i++){
                if(nums[i] < pivot){
                    small.add(nums[i]);
                }else if(nums[i] == pivot){
                    equal.add(nums[i]);
                }else{
                    large.add(nums[i]);
                }
            }
            int i=0;
            for(int ele: small){
                nums[i] = ele;
                i++;
            }
            for(int ele: equal){
                nums[i] = ele;
                i++;
            }
            for(int ele: large){
                nums[i] = ele;
                i++;
            }
            return nums;

   }

   public static void main(String[] args) {
    int[] arr = {9,12,5,10,14,3,10};
    for(int i: pivotArray(arr, 10)){
        System.out.println(i);
    }
   }
}
