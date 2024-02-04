/*
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/description/
*/
package DSA.Leetcode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return isValidBST(root, min, max);
    }
    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        
        if(root.val >= max|| root.val <= min) {
            return false;
        }
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        
    }
}
