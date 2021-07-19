package CompanyQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class MaxPrintAs {

    private static int findMaxAs(int n, int[] dp) {
        // base case
        if (n < 0) return -1;
        if (n < 7) return n;

        int ans = 0, currMax = 0, multiplier = 2;

        for (int i = n - 3; i >= 0; i--) {
            if (dp[i] == -1) dp[i] = findMaxAs(i, dp); // call and store result for future
            currMax = multiplier * dp[i];
            if (currMax > ans) ans = currMax;
            multiplier++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[] = new int[n];
        Arrays.fill(dp, -1); // initialize default value
        System.out.println(findMaxAs(n, dp));

    }
}
