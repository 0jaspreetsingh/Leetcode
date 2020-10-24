package DynamicProgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int coins[] = {1, 2, 5}, amount = 11;
        System.out.println(cc.coinChange(coins, amount));
    }
}
