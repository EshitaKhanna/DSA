package DSA.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    int size;

    StackUsingQueues(){
        size = 0;
    }

    int size(){
        return q1.size();
    }

    void push(int element){
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }

        q1.add(element);
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        size++;
    }

    int pop(){
        if(!q1.isEmpty()){
            return q1.remove();
        }
        size--;
        return -1;
    }

    int peek(){
        if(q1.isEmpty()){
            return -1;
        }

        return q1.peek();
    }

    boolean isEmpty(){
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues s = new StackUsingQueues();
        for(int i=0; i<= 5; i++){
            s.push(i);
        }

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
