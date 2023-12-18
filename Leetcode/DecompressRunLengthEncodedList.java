/*
 * 1313. Decompress Run-Length Encoded List
 * https://leetcode.com/problems/decompress-run-length-encoded-list/description/
*/

package DSA.Leetcode;

import java.util.ArrayList;

public class DecompressRunLengthEncodedList {
    public static int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<nums.length; i+=2){
            for(int j=0; j<nums[i]; j++){
                ans.add(nums[i+1]);
            }
        }
        int [] arr = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            arr[i] = ans.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        for(int i: decompressRLElist(arr)){
            System.out.print(i + " ");
        }
    }
}
