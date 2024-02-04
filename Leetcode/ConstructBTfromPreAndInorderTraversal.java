/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
*/
package DSA.Leetcode;

public class ConstructBTfromPreAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    public TreeNode buildTree(int[] in, int[] pre, int inS, int inE, int preS, int preE) {
        if(inS > inE){
            return null;
        }
        int rootData = pre[preS];
        TreeNode root = new TreeNode(rootData);

        // finding index of root in inorder array
        int rootIndex = -1;
        for(int i = inS; i<=inE; i++){
            if(in[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1){
            return null;
        }

        int leftInS = inS ;
        int leftInE = rootIndex - 1;
        int leftPreS = preS + 1;
        int leftPreE = leftInE - leftInS + leftPreS;

        int rightInS = rootIndex + 1;
        int rightInE = inE;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;

        root.left = buildTree(in, pre, leftInS, leftInE, leftPreS, leftPreE);
        root.right = buildTree(in, pre, rightInS, rightInE, rightPreS, rightPreE);

        return root;
    }

    public static void main(String[] args) {
        
    }
}
