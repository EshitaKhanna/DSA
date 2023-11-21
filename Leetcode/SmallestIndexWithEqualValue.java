/*
 * 2057. Smallest Index With Equal Value
 * https://leetcode.com/problems/smallest-index-with-equal-value/description/
*/

package DSA.Leetcode;

public class SmallestIndexWithEqualValue {
    public static int smallestEqual(int[] nums) {
        int min = Integer.MAX_VALUE;
        int index=0;
        for(int i =0; i<nums.length; i++){
            if(i % 10 == nums[i]){
                index = i;
                if (index < min){
                    min = index;
                    return index;
                 }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2};
        System.out.println(smallestEqual(arr));
    }
}
