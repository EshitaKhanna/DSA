/*
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
*/
package DSA.Leetcode;

public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);

        if((Math.abs(left - right)) > 1 ){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        
    }
}
