/*
 * 2859. Sum of Values at Indices With K Set Bits
 * https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/
*/

package DSA.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumOfValuesAtIndicesWithKSetBits {
    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        int len = nums.size();
        int[] binary_arr = new int[len];

        for(int i=0; i<len; i++){
            String binary_value = Integer.toBinaryString(i);
            binary_arr[i] = Integer.parseInt(binary_value);
            if(countOnes(binary_arr[i]) == k){
                sum+= nums.get(i);
            }
        }

        return sum;
    }
    public static int countOnes(int a){
        int ans = 0;
        while(a>0){
            int digit = a%10;
            if(digit == 1){
            ans ++;
            }
            a = a/10;
        }   
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(10);
        arr.add(1);
        arr.add(5);
        arr.add(2);
        System.out.println(sumIndicesWithKSetBits(arr, 1));
    }
}
