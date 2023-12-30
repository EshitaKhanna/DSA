/*
 * 1812. Determine Color of a Chessboard Square
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/
*/
package DSA.Leetcode;

public class DetermineColorOfAChessboardSquare {
    public static boolean squareIsWhite(String coordinates) {

        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '1';

        int sum = x+y;
        if(sum % 2 == 0){
            //black
            return false;
        }
        // white
        return true; 
    }

    public static void main(String[] args) {
        String s = "a1";
        System.out.println(squareIsWhite(s));
    }
}
