/*
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
*/

package DSA.Leetcode;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int first = 1;
        int second = 2;

        for(int i=2; i<n; i++){
            int next = first+ second;
            first = second;
            second = next;
        }

        return second;

        //return fib(n);
    }

    public static int fib(int n){
        if(n<=1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
