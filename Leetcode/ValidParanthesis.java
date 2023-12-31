package DSA.Leetcode;

import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
       
       for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
               stack.push(s.charAt(i));
            }
            else if(stack.isEmpty()){
                return false;
            }
            else if(stack.peek() == '(' && s.charAt(i) == ')'){
                stack.pop();
            }
            else if(stack.peek() == '{' && s.charAt(i) == '}'){
                stack.pop();
            }
            else if(stack.peek() == '[' && s.charAt(i) == ']'){
                stack.pop();
            }
            else{
                return false;
            }
        }
        
        return stack.isEmpty();
    
    }

    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }
}
