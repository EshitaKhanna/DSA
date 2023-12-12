package DSA.Stack;

import java.util.Stack;

public class MinimumBracketReversal {
    public static int countBracketReversals(String input) {

        int length = input.length();
        int count = 0;

        if(length % 2 != 0){
            return -1;
        }
        else{
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<length; i++){
                char ch = input.charAt(i);

                if(ch == '{'){
                    stack.push(ch);
                }
                else{
                    if(stack.isEmpty()){
                        stack.push(ch);
                    }
                    else if(!stack.isEmpty()){
                        if(stack.peek() == '{'){
                            stack.pop();
                        }else{
                            stack.push(ch);
                        }
                    }
                    
                }
            }
            while(!stack.isEmpty()){
                char c1 = stack.pop();
                char c2 = stack.pop();

                if(c1 == c2){
                    count ++;
                }else{
                    count += 2;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        String s = "{}}}";
        System.out.println(countBracketReversals(s));
    }
}
