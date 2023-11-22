/*
 * 2011. Final Value of Variable After Performing Operations
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/
*/

package DSA.Leetcode;

public class FindValueOfVariable {
    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i =0; i<operations.length; i++){
            //if(operations[i].equals("++X")|| operations[i].equals("X++")){
            if(operations[i].charAt(1) == '+'){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        String[] s ={"++X","++X","X++"};
        System.out.println(finalValueAfterOperations(s));
    }
}
