/*
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/description/
*/
package DSA.Leetcode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if((p == null && q != null) || (p != null && q == null)){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        
    }
}
