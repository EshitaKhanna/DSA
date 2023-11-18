/*
 * 1619. Mean of Array After Removing Some Elements
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/description/
*/

package DSA.Leetcode;

import java.util.Arrays;

public class MeanOfArrayAfterRemovingElements {
        public static double trimMean(int[] arr) {
        int n = arr.length;
        double num_of_ele = 0.05 * n;
        Arrays.sort(arr);

        double sum = 0;
        for(int i= (int)(num_of_ele); i < n - num_of_ele; i++){
            sum += arr[i];
        }

        double mean = sum/(n-(int)(2*num_of_ele));
        return mean;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        System.out.println(trimMean(arr));
    }
}
