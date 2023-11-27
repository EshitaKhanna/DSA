/*
 * 2652. Sum Multiples
 * https://leetcode.com/problems/sum-multiples/description/
*/
package DSA.Leetcode;

public class SumMultiples {
    public static int sumOfMultiples(int n) {
        int sum =0;
        for(int i=1; i<n+1; i++){
            if(i%3 ==0 || i%5 == 0 || i%7 ==0){
                sum += i;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
    }
}
