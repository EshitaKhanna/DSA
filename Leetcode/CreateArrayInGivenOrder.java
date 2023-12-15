/*
 * 1389. Create Target Array in the Given Order
 * https://leetcode.com/problems/create-target-array-in-the-given-order/description/
*/

package DSA.Leetcode;

import java.util.ArrayList;

public class CreateArrayInGivenOrder {
    public static int[] createTargetArray(int[] nums, int[] index) {
    ArrayList<Integer> ans = new ArrayList<>();
    int[] target = new int[nums.length];
    
    for(int i=0;i<nums.length; i++){
        ans.add(index[i], nums[i]);
    }

    for(int i=0; i<nums.length; i++){
        target[i] = ans.get(i);
    }

    return target;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,2,3,4};
        int index[] = {0,1,2,2,1};

        for(int i : createTargetArray(nums, index)){
            System.out.print(i + " ");
        }
    }
}
