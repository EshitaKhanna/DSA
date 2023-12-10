package DSA.Stack;

import java.util.Stack;

public class RedundantBrackets {
    public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch != ')'){
                stack.push(ch);
            }
            else{
                while(!stack.isEmpty() && stack.peek() != '('){
                    stack.pop();
                    count++;
                }
                if(count == 0 || count == 1){
                    return true;
                }

                stack.pop();
                count = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
            String s = "((a+b))";
            System.out.println(checkRedundantBrackets(s));
    }
}
