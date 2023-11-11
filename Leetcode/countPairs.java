/*
 * 2824. Count Pairs Whose Sum is Less than Target
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/    
*/

package DSA.DSA.Leetcode;

import java.util.Arrays;
import java.util.List;

public class countPairs{
    public static int countPairsWhoseSumIsLessThanTarget(List<Integer> nums, int target) {
        int n = nums.size();
        int [] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = nums.get(i);
        }
        Arrays.sort(arr);
        
        int count = 0;
        int i=0;
        int j = n-1;

        while(i<j){
            int sum = arr[i] + arr[j];
            if(sum < target){
                count += j-i;
                i++;
            }else{
                j--;
            }
        }

        return count;
    }

    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(-1,1,2,3,1);
        System.out.println(countPairsWhoseSumIsLessThanTarget(nums, 2)); //output = 3
    }
}