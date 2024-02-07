package DSA.BinaryTrees;

import java.util.ArrayList;
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

    public static int minimumValue(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minimumValue(root.left), minimumValue(root.right)));
    }

    public static int maximumValue(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maximumValue(root.left), maximumValue(root.right)));
    }
    
    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root == null){
            return true;
        }
        int rightMin = minimumValue(root.right);
        int leftMax = maximumValue(root.left); 
        if(root.data <= leftMax || root.data > rightMin){
            return false;
        }
        boolean left = isBST(root.left);
        boolean right = isBST(root.right);

        return left && right;
    }

    public static Pair<Boolean, Pair<Integer, Integer>> isBST2(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
            output.first = true;
            output.second = new Pair<Integer, Integer>();
            output.second.first = Integer.MAX_VALUE;
            output.second.second = Integer.MIN_VALUE;

            return output;
        }
        Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST2(root.left);
        Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST2(root.right);

        int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
        int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
        boolean isBST = (root.data > leftOutput.second.second) 
                        && (root.data <= rightOutput.second.first)
                        && leftOutput.first 
                        && rightOutput.first;

        Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
        output.first = isBST;
        output.second = new Pair<Integer, Integer>();
        output.second.first = min;
        output.second.second = max;

        return output;
        
    }

    public static BinaryTreeNode<Integer> constructBST(int[] arr, int low, int high){
        if(high < low){
            return null;
        }
        int mid = (high+low)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
        root.left = constructBST(arr, low, mid-1);
        root.right = constructBST(arr, mid+1, high);

        return root;
    }
    
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if(root == null){
            return false;
        }
        if(root.data == k){
            return true;
        }
        else if(k < root.data){
            return searchInBST(root.left, k);
        }
        else{
            return searchInBST(root.right, k);
        }
    }
    
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
        if(root == null){
            return;
        }

        if(root.data < k1){
            elementsInRangeK1K2(root.right, k1, k2);
        }
        else if(root.data > k2){
            elementsInRangeK1K2(root.left,k1,k2);
        }
        else{
            elementsInRangeK1K2(root.left,k1,k2);
            System.out.println(root.data + " ");
            elementsInRangeK1K2(root.right,k1,k2);
        }
    }
    
    public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            return null;
        }
        if(root.data == data){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput = getRootToNodePath(root.left, data);
        if(leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = getRootToNodePath(root.right, data);
        if(rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }else{
            return null; // not found in left, right subtree or root
        }

    }
    
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        if(isBST(root)){
            return height(root);
        }
        else{
            int leftOutput = largestBSTSubtree(root.left);
            int rightOutput = largestBSTSubtree(root.right);

            return Math.max(leftOutput, rightOutput);
        }
    }
    
    private static ArrayList<Integer> BSTtoArray(BinaryTreeNode<Integer> root){
        if(root == null){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            return arr;
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();

        ArrayList<Integer> left = BSTtoArray(root.left);
        ArrayList<Integer> right = BSTtoArray(root.right);

        if(left !=null){
            arr.addAll(left);
        }
        arr.add(root.data);
        if(right != null){
            arr.addAll(right);
        }

        return arr;
        
    }
    
    private static void pairSum(ArrayList<Integer> arr, int s){
        int start = 0;
        int end = arr.size()-1;

        while(start < end){
            int sum = arr.get(start) + arr.get(end);
            if(sum > s){
                end--;
            }else if(sum < s){
                start++;
            }else{
                System.out.println(arr.get(start) + " " + arr.get(end));
                start++;
                end--;
            }
        }
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if(root == null){
            return;
        }
        ArrayList<Integer> arr = BSTtoArray(root);
        pairSum(arr, s);

    }
    
    private static Pair<Integer, BinaryTreeNode<Integer>> isCousinHelper (BinaryTreeNode<Integer> root, 
                                                            int val, BinaryTreeNode<Integer> parent, 
                                                            int level){
        if(root == null){
            return null;
        }
        if(root.data == val){
            Pair<Integer,BinaryTreeNode<Integer>> output = new Pair<>();
            output.first = level;
            output.second = parent;
            
            return output;
        }
        Pair<Integer,BinaryTreeNode<Integer>> leftOutput = isCousinHelper(root.left, val, parent, level+1);
        Pair<Integer,BinaryTreeNode<Integer>> rightOutput = isCousinHelper(root.right, val, parent, level+1);

        if(leftOutput == null){
            return rightOutput;
        }else{
            return leftOutput;
        }
        

    }
   
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        // cousin if:
        // p.level == q.level and
        // p.parent != q.parent

        // let in pair class first = level and second = parent;
        Pair<Integer,BinaryTreeNode<Integer>> pPair = isCousinHelper(root, p, null, 0);
        Pair<Integer,BinaryTreeNode<Integer>> qPair = isCousinHelper(root, q, null, 0);

        if((pPair.first == qPair.first) && (pPair.second != qPair.second)){
            return true;
        }
        return false;
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
