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

        Node<Integer> head = takeInput();
        print(head);
        
    }
    
}
