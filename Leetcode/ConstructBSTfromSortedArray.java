/*
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
*/
package DSA.Leetcode;

public class ConstructBSTfromSortedArray {
    public TreeNode sortedArrayToBST(int[] nums){
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] arr, int low, int high) {
        if(high < low){
            return null;
        }
        int mid = (high+low)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedArrayToBST(arr, low, mid-1);
        root.right = sortedArrayToBST(arr, mid+1, high);

        return root;
    }

    public static void main(String[] args) {
        
    }
}
