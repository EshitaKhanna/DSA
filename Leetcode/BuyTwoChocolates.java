/*
 * 2706. Buy Two Chocolates
 * https://leetcode.com/problems/buy-two-chocolates/description/
*/
package DSA.Leetcode;

import java.util.Arrays;

public class BuyTwoChocolates {
    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int min = prices[0] + prices[1];
        int money_left = money - min;
        if(money_left >= 0){
            return money_left;
        }

        return money;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,2};
        System.out.println(buyChoco(prices, 3));
    }
}
