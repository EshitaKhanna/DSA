package DSA.Queue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    private int size;

    QueueUsingStack(){
        size = 0; 
    }

    int size(){
        return s1.size();
    }

    void enqueue(int element){
        s1.push(element);
        size++;
    }

    int dequeue(){
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
         }
    
        if (s2.isEmpty()) {
            return -1; // The queue is empty
        }

        int del_ele = s2.pop();
        size--;

        return del_ele; 
    

    }

    int peek(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
            int ele = s1.pop();
            s2.push(ele);
            }
        }
    
        return s2.isEmpty() ? -1 : s2.peek();
    }

    boolean isEmpty(){
        return (size==0);
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
