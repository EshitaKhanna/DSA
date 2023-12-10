package DSA.Stack;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
        if(input.size() == 0 || input.size() == 1){
            return ;
        }

        while( !input.isEmpty()){
            int temp = input.peek();
            input.pop();
            extra.push(temp);
        }
    }
    public static void main(String[] args) {
        int []arr = {2, 8, 15, 1, 10, 5};
        Stack<Integer> input = new Stack<>();
        for(int i =0; i<arr.length; i++){
            input.push(arr[i]);
        }

        Stack<Integer> extra = new Stack<>();
        reverseStack(input, extra);

        while( !extra.isEmpty()){
            System.out.println(extra.pop());
            
        }
    }
}
