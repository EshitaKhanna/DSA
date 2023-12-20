package DSA.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> input) {
        if(input.isEmpty()){
            return ;
        }
        int ele = input.remove();
        reverseQueue(input);
        input.add(ele);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=5; i++){
            q.add(i);
        }

        System.out.println(q);
        reverseQueue(q);
        System.out.println(q);

    }
}
