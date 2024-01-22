package DSA.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

    public static TreeNode<Integer> takeInput(Scanner s){
        int n;
        System.out.println("Enter next node data: ");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);

        System.out.println("Enter number of children for " + n);
        int childCount = s.nextInt();

        for(int i=0; i<childCount; i++){
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }
        return root;
    }

    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data: ");
        int rootData = s.nextInt();

        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter number of children of "+ frontNode.data);
                int numChildren = s.nextInt();
                for(int i=0; i<numChildren; i++){
                    System.out.println("Enter " + (i+1) + "th child of " + frontNode.data);
                    int child = s.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<Integer>(child);
                    frontNode.children.add(childNode);
                    pendingNodes.enqueue(childNode);
                }
            } catch (QueueEmptyException e) {
                return null; 
                // this situation wont occur;
            }
        }

        return root;
    }

    public static void print(TreeNode<Integer> root){
        String s = root.data + ": ";
        for(int i=0; i<root.children.size(); i++){
            s += root.children.get(i).data + ",";
        }
        System.out.println(s);
        for(int i=0; i<root.children.size(); i++){
           print(root.children.get(i));
        }
    }
    
    public static void printLevelWise(TreeNode<Integer> root) throws QueueEmptyException{
        String s = root.data + ": ";
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        pendingNodes.enqueue(root);

        while(!pendingNodes.isEmpty()){
            int pendingNodesSize = pendingNodes.size();
            for(int i=0; i<pendingNodesSize; i++){
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.print(frontNode.data + " ");
                for(int j=0; j<frontNode.children.size(); j++){
                    pendingNodes.enqueue(frontNode.children.get(j));
                }
            }
            System.out.println();     
        }
    }

    public static int numNodes(TreeNode<Integer> root){
        // root == null is not a base case
        // this is an edge case
        if(root == null){
            return 0;
        }
        int count = 1;
        for(int i=0; i<root.children.size(); i++){
            count += numNodes(root.children.get(i));
        }

        return count;
    }
    
    public static int largestNode(TreeNode<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int ans = root.data;
        for(int i=0; i<root.children.size(); i++){
            int childLargest = largestNode(root.children.get(i));
            if(childLargest > ans){
                ans = childLargest;
            }
        }

        return ans;
    }
    
    public static int height(TreeNode<Integer> root){
        // height = number of levels
        // we consider root node as 1 level
        if(root == null){
            return 0;
        }
        int height = 0;
        for(int i=0; i<root.children.size(); i++){
            int childHeight = height(root.children.get(i));
            if(childHeight > height){
                height = childHeight;
            }
        }
        return 1+ height; // plus 1 for root node
    }
    
    public static void printAtKdepth(TreeNode<Integer> root, int k){
        // depth = distance from the root node
        if(k<0){
            return;
        }
        if(k==0){
            System.out.println(root.data + " ");
        }

        for(int i=0; i<root.children.size(); i++){
            printAtKdepth(root.children.get(i), k-1);
        }

    }

    public static int sumOfAllNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
    
        int sum = root.data;
        for(int i=0; i<root.children.size(); i++){
            int ans = sumOfAllNodes(root.children.get(i));
            sum += ans;
        }
        return sum;
    }

    public static int numNodesGreater(TreeNode<Integer> root, int k){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.data > k){
            count++;
        }
        for(int i=0; i<root.children.size(); i++){
            int ans = numNodesGreater(root.children.get(i), k);
            count += ans;
        }
        return count;
    }

    public static int countLeafNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        int count = 0;
        if(root.children.size()==0) {
			count++;
		}

        for(int i=0; i<root.children.size(); i++){
            int ans = countLeafNodes(root.children.get(i));
            count += ans;
        }
        return count;
    }

    public static void printPreOrder(TreeNode<Integer> root) {
        // Root Left Right
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        for(int i=0; i<root.children.size(); i++){
            printPreOrder(root.children.get(i));
        }
    }

    public static void printPostOrder(TreeNode<Integer> root) {
        // Left Right Root
        if(root == null){
            return;
        }
        for(int i=0; i<root.children.size(); i++){
            printPostOrder(root.children.get(i));
        }

        System.out.println(root.data);
    }

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {
        if(root == null){
            return false;
        }

        if(root.data == x){
            return true;
        }
        for(int i = 0; i<root.children.size(); i++){
            boolean ans = checkIfContainsX(root.children.get(i), x);
            if(ans == true){
                return true;
            }
        }
        return false;
    }

    // public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root, int maxSum){
    //     TreeNode<Integer> maximumNode = null;
    //     int rootSum = root.data;
    //     for(int i=0; i<root.children.size(); i++){
    //         rootSum += root.children.get(i).data;
    //     }
    //     if(rootSum > maxSum){
    //     }
    //     return maximumNode;
    // }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if((root1 == null && root2 != null) ||(root1 != null && root2 == null)){
            return false;
        }

        if((root1.data != root2.data) || (root1.children.size() != root2.children.size())){
            return false;
        }

        for(int i=0; i<root1.children.size(); i++){
            TreeNode<Integer> child1 = root1.children.get(i);
            TreeNode<Integer> child2 = root2.children.get(i);
            boolean ans = checkIdentical(child1, child2);

            if(ans != true){
                return false;
            }
        }

        return true;
    }
    
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        if(root == null){
            return null;
        }   

        TreeNode<Integer>  nextLarger = null;

        Queue<TreeNode<Integer>> pending = new LinkedList<>();
        pending.add(root);
        while (!pending.isEmpty()) {
            TreeNode<Integer> front = pending.poll();
			if(front.data > n && (nextLarger == null || front.data < nextLarger.data)) {
				nextLarger = front;
			}

            for(int i =0; i < front.children.size(); i++) {
				pending.add(front.children.get(i));
			}
        }

        
        return nextLarger;
        
	}

    // public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
    // }

    public static void replaceWithDepthValue(TreeNode<Integer> root){
        replaceWithDepthValue(root, 0);

    }
    public static void replaceWithDepthValue(TreeNode<Integer> root, int depth){
        root.data = depth;
        for(int i=0; i<root.children.size(); i++){
            replaceWithDepthValue(root.children.get(i), depth+1);
        }
    }

    public static void main(String[] args) throws QueueEmptyException {
        Scanner s = new Scanner(System.in);
        //TreeNode<Integer> root = takeInput(s);
        TreeNode<Integer> root = takeInputLevelWise();
        //print(root);
        printLevelWise(root);
        System.out.println("Number of nodes: " + numNodes(root));
        System.out.println("Largest Node: " + largestNode(root));
        System.out.println("Height: " + height(root));
        printAtKdepth(root, 1);
        System.out.println("Sum of all Nodes: " + sumOfAllNodes(root));
        System.out.println("Number of Nodes greater than: " + numNodesGreater(root,10));
        System.out.println("Number of Leaf Nodes: " + countLeafNodes(root));
        System.out.println("Searching: " + checkIfContainsX(root, 10));

        // replaceWithDepthValue(root);


        
//        TreeNode<Integer> node1 = new TreeNode<Integer>(2);
//        TreeNode<Integer> node2 = new TreeNode<Integer>(3);
//        TreeNode<Integer> root = new TreeNode<Integer>(4);
//        TreeNode<Integer> node3 = new TreeNode<Integer>(5);
//        TreeNode<Integer> node4 = new TreeNode<Integer>(6);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
//        System.out.println(root);

    }
}
