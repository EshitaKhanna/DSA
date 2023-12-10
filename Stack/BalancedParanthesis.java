package DSA.Stack;
import java.util.Stack;
public class BalancedParanthesis{
    public static boolean isBalanced(String expression) {
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(0) == ')'){
                return false;
            }else if(expression.charAt(i) == '('){
                stack.push(expression.charAt(i));
            }else if(expression.charAt(i) == ')'){
                if( !stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        else{
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "(())";
        System.out.println(isBalanced(s));
    }
}