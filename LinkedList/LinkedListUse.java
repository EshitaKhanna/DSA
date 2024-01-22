package DSA.LinkedList;

import java.util.Scanner;

public class LinkedListUse {

    public static void print(Node<Integer> head){
        //Printing the linked list
        Node<Integer> temp = head;

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
        head = temp;
    }
    
    public static Node<Integer> takeInput(){
        // Time complexity: O(n^2) as we traverse the list every time before inserting the next node
        Node<Integer> head = null;
        Scanner s = new Scanner(System.in);
        
        int data = s.nextInt();

        while(data != -1){
            Node<Integer>  newNode = new Node<Integer>(data);
            if(head == null) {
                head = newNode; 
            }else{
                Node<Integer> temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            data = s.nextInt(); 
        }
        return head;
    } 

    public static Node<Integer> takeInput2(){

        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner s = new Scanner(System.in);
        
        int data = s.nextInt();

        while(data != -1){
            Node<Integer>  newNode = new Node<Integer>(data);
            if(head == null) {
                head = newNode; 
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode; //tail = tail.next;
            }
            data = s.nextInt(); 
        }
        return head;
    } 

    public static Node<Integer> insert(Node<Integer> head, int data, int position){
        
        Node<Integer> newNode = new Node<>(data);

        //insertion at beginning

        if(position == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }


        //insertion at specific position / end
        int i=0;
        Node<Integer> temp = head;
        while(i < position -1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        return head;

    }
   
    public static Node<Integer> delete(Node<Integer> head, int position){

        if(position == 0){
            head = head.next;
            return head;
        }

        Node<Integer> temp = head;
        int i =0;

        while(i<position - 1 && temp != null && temp.next != null){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return head;
   }
   
    public static int findNode(Node<Integer> head, int n){
        Node<Integer> temp = head;
        int i =0;
        while(temp != null && temp.data != n){
            temp = temp.next;
            i++;
        }
        if(temp != null){
            return i;
        }
        return -1;
    }

    public static Node<Integer> removeDuplicates(Node<Integer> head){
        if(head == null){
            return head;
        }
        Node<Integer> temp = head;
        while(temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }

    public static void printReverse(Node<Integer> head) { 

    }

    public static Node<Integer> middleNode(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> list1, Node<Integer> list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        Node<Integer> head1 = list1, head2 = list2, head = null, tail = null;

        if(head1.data <= head2.data){
            head = head1;
            tail = head1;
            
            head1 = head1.next;
            
        }else {
        	head = head2;
            tail = head2;
            
            head2 = head2.next;
        }
        
        while (head1 != null && head2 != null) {
        	if(head1.data <= head2.data){
                tail.next = head1;
                tail = head1;
                
                head1 = head1.next;
                
            }else {
            	tail.next = head2;
                tail = head2;
           
                head2 = head2.next;
            }
        }
        
        if(head1 != null) {
        	tail.next = head1;
        }else {
        	tail.next = head2;
        }
        return head;
    }
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(10);
        //System.out.println(node1.data);
        //System.out.println(node1.next);

        //Node<Integer> node2 = new Node<Integer>(20);
        //Node<Integer> node3 = new Node<Integer>(30);
        //node1.next = node2;
        //node2.next = node3;

        //Node<Integer> head =  node1;
        //print(head);

        Node<Integer> head1 = takeInput2();
        print(head1);

        //head = insert(head, 80, 0);
        //head = delete(head, 0);
        //print(head);

        //System.out.println(findNode(head, 50));
        //head = removeDuplicates(head);
        //head = middleNode(head);

        Node<Integer> head2 = takeInput2();
        head1  = mergeTwoSortedLinkedLists(head1, head2);
        print(head1);

    }    
}
