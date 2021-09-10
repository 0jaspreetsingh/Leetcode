package Strings;

/**
 * 583. Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 * similar to longest common subsequence
 */
public class DeleteOpToMakeStringsEqual {

    public int minDistance(String word1, String word2) {

        int l1 = word1.length(), l2 = word2.length();
        int dp[][] = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return l1 + l2 - 2 * dp[l1][l2];
    }

    // Always use this way, more easier to understand
    public int minDistanceRecursionAndMemorization(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), memo);
    }

    public int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] > 0)
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
        return memo[m][n];
    }

    public static void main(String[] args) {
        DeleteOpToMakeStringsEqual d = new DeleteOpToMakeStringsEqual();
        System.out.println(d.minDistance("sea", "eat"));
    }
}
