package DSA.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeInput(Scanner s){
        int rootData;   
        System.out.println("Enter root data: ");
        rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);

        return root;
        
    }

    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String s = root.data + ": ";
        if(root.left != null){
            s += "L:" + root.left.data + ", ";
        }
        if(root.right != null){
            s += "R:" + root.right.data + ", ";
        }
        System.out.println(s);

        printTree(root.left);
        printTree(root.right);
    }
    
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("Enter root data: ");
        int rootData = s.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front = pendingNodes.poll();
            System.out.println("Enter left child of " + front.data);
            int leftChild = s.nextInt();
            if(leftChild != -1){
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(leftChild);
                pendingNodes.add(leftNode);
                front.left = leftNode;
            }

            System.out.println("Enter right child of " + front.data);
            int rightChild = s.nextInt();
            if(rightChild != -1){
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(rightChild);
                pendingNodes.add(rightNode);
                front.right = rightNode;    
            }
            
        }
        return root;



        
    }
    
    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String s = root.data + ": ";
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodes.poll();
            System.out.print(front.data + ": ");
            if(front.left != null){
                System.out.print("L" + front.left.data + ", ");
                pendingNodes.add(front.left);
            }
            if(front.right != null){
                System.out.print("R" + front.right.data);
                pendingNodes.add(front.right);
            }
            System.out.println();
        }
    }
    
    public static int countNodes(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;   
        }
        int count = 1;
        count += countNodes(root.left);
        count += countNodes(root.right);

        return count;

    }
    
    public static int getSum(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int sum = root.data + leftSum + rightSum;

        return sum;

    }
    
	public static void preOrder(BinaryTreeNode<Integer> root){
        //root left right
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(BinaryTreeNode<Integer> root){
        // left right root
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void inOrder(BinaryTreeNode<Integer> root){
        // left root right
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);

    }

    public static int nodeWithLargestData(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int ans = root.data;
        int left = nodeWithLargestData(root.left);
        int right = nodeWithLargestData(root.right);

        return Math.max(ans, Math.max(left, right));

    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return 0;
        }

        int left = countNodesGreaterThanX(root.left, x);
        int right = countNodesGreaterThanX(root.right, x);

        if(root.data > x){
            return left+right+1;
        }else{
            return left+right;
        }
    
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if(root == null){
            return false;
        }

        boolean flag = false;
        if(root.data == x){
            flag = true;
        }
        else{
            flag = isNodePresent(root.left, x) || isNodePresent(root.right, x);
        }
        return flag;
    }

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        if(root.left == null){
            System.out.print(root.right.data + " ");
            printNodesWithoutSibling(root.right);           
        }
        else if(root.right == null){
            System.out.print(root.left.data + " ");
            printNodesWithoutSibling(root.left);

        }
        else{
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
        }
    }

    public static int height(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1 ;
    }

    public static int diameter(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int height = height(root.left) + height(root.right);
        int left = diameter(root.left);
        int right = diameter(root.right);

        return Math.max(height,Math.max(left, right));
    }
    
    public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<Integer, Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }
        Pair<Integer, Integer> leftOutput = heightDiameter(root.left);
        Pair<Integer, Integer> rightOutput = heightDiameter(root.right);

        int height = 1 + Math.max(leftOutput.first, rightOutput.first);
        int diameter = Math.max(leftOutput.first + rightOutput.first, 
                                Math.max(leftOutput.second, rightOutput.second));

        Pair<Integer, Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;
        return output;                     
        
    } 
    
    public static BinaryTreeNode<Integer> buildTree(int[] inorder, int[] preorder){
        return buildTreeHelper(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);

    }

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] in, int[] pre, int inS, int inE, int preS, int preE){

        if(inS > inE){
            return null;
        }
        int rootData = pre[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

        // finding index of root in inorder array
        int rootIndex = -1;
        for(int i = inS; i<inE; i++){
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

        root.left = buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
        root.right = buildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);

        return root;


    }
    
    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
        if(root==null) {
            return null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }
    
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        //time complexity Worst case:- O(n2), avg case:- O(nlogn)
        if(root==null) {
            return true;
          }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) >1){
            return false;
        }

        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        return isLeftBalanced && isRightBalanced ;
    }
    
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }

        BinaryTreeNode<Integer> duplicate = new BinaryTreeNode<Integer>(root.data);
        BinaryTreeNode<Integer> left = root.left;
        root.left = duplicate;
        duplicate.left = left;

        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        String s = "";
        rootToLeafPathsSumToK(root, k, s);
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String s) {
        
        if(root == null){
            return;
        }

        if(root.data == k && root.left == null && root.right == null){
            System.out.println(s + root.data);
            return;

        }

        s += root.data + " ";
        rootToLeafPathsSumToK(root.left, k- root.data, s);
        rootToLeafPathsSumToK(root.right, k- root.data, s);

    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {

    }    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();

        printLevelWise(root);
        System.out.println("Number of nodes: " + countNodes(root));
        System.out.println("Sum of nodes: " + getSum(root));
        // preOrder(root);
        // postOrder(root);
        System.out.println("Largest Node: " + nodeWithLargestData(root));
        System.out.println("Number of nodes greater than target" + countNodesGreaterThanX(root, 5));
        System.out.println("Check node is present: " + isNodePresent(root, 6));
        System.out.println("Nodes without sibling: ");
        printNodesWithoutSibling(root);
        System.out.println("Height: " + heightDiameter(root).first);
        System.out.println("Diameter: " + heightDiameter(root).second);
        
        
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
        // BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(2);
        // BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(3);

        // root.left = node1;
        // root.right = node2;
        


    }
    
}
