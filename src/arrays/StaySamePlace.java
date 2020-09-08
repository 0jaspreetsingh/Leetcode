package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 */
public class StaySamePlace {

    int ans = 0;
    int mod = 1000000007;
    long dp[][];


    public int numWays(int steps, int arrLen) {
        int maxPositions = Math.min(steps, arrLen);
        dp = new long[steps + 1][maxPositions + 1];
        dp[0][0] = 0;
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= steps; i++) {
            for (int j = 0; j < maxPositions; j++) {
                long canMoveLeft = j > 0 ? dp[i - 1][j - 1] : 0;
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1] + canMoveLeft) % mod;
            }
        }


        return (int) dp[steps][0];
    }

    //Time Limit Exceed
//    private void choices(int currentIndex, int stepsLeft, int arrLen) {
//        System.out.println(ans);
//        if (currentIndex < 0 || currentIndex >= arrLen) {
//            return;
//        }
//
//        if (stepsLeft<0){
//            return;
//        }
//
//
//        if (stepsLeft == 0) {
//            if (currentIndex == 0) {
//                ans++;
//                ans%=mod;
//            }
//            return;
//        }
//
//        //moveLeft
//        choices(currentIndex - 1, stepsLeft - 1, arrLen);
//        //moveRight
//        choices(currentIndex + 1, stepsLeft - 1, arrLen);
//        //stay
//        choices(currentIndex, stepsLeft - 1, arrLen);
//    }

    public static void main(String[] args) {
        StaySamePlace ssp = new StaySamePlace();
        int steps = 27, arrLen = 7;
        System.out.println(ssp.numWays(steps, arrLen));
    }
}
