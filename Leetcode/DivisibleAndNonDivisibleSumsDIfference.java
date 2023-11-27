/*
 * 2894. Divisible and Non-divisible Sums Difference
 * https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/
*/
package DSA.Leetcode;

public class DivisibleAndNonDivisibleSumsDIfference {
    public static int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for(int i=1; i<n+1; i++){
            if(i%m != 0){
                num1 += i;
            }else{
                num2 += i;
            }
        }
        return num1-num2;
    }

    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3)); // output = 19
    }
    
}
