/*
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
*/
package DSA.Leetcode;

public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min_price = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            if(prices[i] < min_price){
                min_price = prices[i];
            }

            int curr_profit = prices[i] - min_price;
            profit = Math.max(profit, curr_profit);

        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
