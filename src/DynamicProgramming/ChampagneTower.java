package DynamicProgramming;

/**
 * https://leetcode.com/problems/champagne-tower/
 */
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][] = new double[101][101];
        dp[0][0] = poured;
        loop:
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double inNextLevel = (dp[i][j] - 1.0) / 2.0;
                if (inNextLevel > 0) {
                    dp[i + 1][j] += inNextLevel;
                    dp[i + 1][j + 1] += inNextLevel;
                }
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }

}
