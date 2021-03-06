package main;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        boolean bought = false;
        boolean sold = false;

        int profitSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profitSoFar += prices[i] - prices[i - 1];
            }
        }

        return profitSoFar;
    }

    public static void main(String args[]) {
        BestTimetoBuyandSellStockII dc = new BestTimetoBuyandSellStockII();
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(dc.maxProfit(prices));
    }

}
