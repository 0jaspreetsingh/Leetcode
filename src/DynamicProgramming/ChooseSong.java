package DynamicProgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-music-playlists/solution/
 */
public class ChooseSong {

    public int numMusicPlaylists(int N, int L, int K) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; ++i)
            for (int j = 1; j <= N; ++j) {
                dp[i][j] += dp[i - 1][j - 1] * (N - j + 1);
                dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0);
                dp[i][j] %= MOD;
            }

        for (long i[] : dp) {
            System.out.println(Arrays.toString(i));
        }

        return (int) dp[L][N];
    }

    public static void main(String[] args) {
        ChooseSong s = new ChooseSong();
        System.out.println(s.numMusicPlaylists(3, 3, 1));
    }
}
