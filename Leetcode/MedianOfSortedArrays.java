/*
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
*/

package DSA.Leetcode;

public class MedianOfSortedArrays{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] sorted = new int[n1+n2];

        int i=0;
        int j=0;
        int k=0;

        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                sorted[k] = nums1[i];
                i++;
                k++;
            }else {
	    		 sorted[k]=nums2[j];
	    		 j++;
                 k++;
	    	}
        }
        while(i<n1) {
	    	 sorted[k]=nums1[i];
	    	 i++;
	    	 k++;
	    }

	    while(j<n2) {
	    	 sorted[k]=nums2[j];
	    	 j++;
	    	 k++;
	    }

        if(sorted.length == 1){
            return (double)sorted[0];
        }else{
            int len = sorted.length;
            if(len % 2 == 1){
                 return (double)(sorted[len/2]);
            }else{   
                return ((double)sorted[len/2]+(double)(sorted[(len-1)/2]))/2.0;
            }
        }
    }
    public static void main(String[] args) {
        int[] n1 = {};
        int[] n2 = {2,3};

        double out = findMedianSortedArrays(n1, n2);
        System.out.println(out);
    }
}
