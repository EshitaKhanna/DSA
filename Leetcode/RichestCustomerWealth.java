/*
 * 1672. Richest Customer Wealth
 * https://leetcode.com/problems/richest-customer-wealth/description/
*/

package DSA.Leetcode;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int max = Integer.MIN_VALUE;
        
        for(int i =0; i<m; i++){
            int n = accounts[i].length;
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += accounts[i][j];
            }

            if(sum > max){
                max = sum;
            }
        }

        return max;
    }

    public static void main(String [] args){
        int [][] accounts = {{1,5},{7,3}, {3,5}};
        System.out.println(maximumWealth(accounts)); // output = 10
    }
}
