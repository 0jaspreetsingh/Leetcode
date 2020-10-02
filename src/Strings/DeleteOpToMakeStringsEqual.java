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

    public static void main(String[] args) {
        DeleteOpToMakeStringsEqual d = new DeleteOpToMakeStringsEqual();
        System.out.println(d.minDistance("sea", "eat"));
    }
}
