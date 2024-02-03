/*
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/description/
*/
package DSA.Leetcode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        
    }
}
