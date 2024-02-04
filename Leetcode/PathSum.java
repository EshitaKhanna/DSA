/*
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/description/
*/
package DSA.Leetcode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }

        boolean flag =  hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        return flag;
    
    }

    public static void main(String[] args) {
        
    }
}
