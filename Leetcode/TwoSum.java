/*
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/    
*/

package DSA.Leetcode;

public class TwoSum{
    public static int[] twoSum(int []arr, int k){

        for(int i = 0; i < arr.length; i++){
            for(int j= i+1; j < arr.length; j++){
                 if(arr[i] + arr[j] == k){
                    return new int[] {i,j};
                 }
            }
        }
        return null;
    }

    public static void main(String []args){
        int[] arr = {2,7,11,15};
        int [] ans = twoSum(arr, 9);
        for(int i: ans){
            System.out.print(i + " ");
        }
            
    }
}