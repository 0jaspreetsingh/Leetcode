package DynamicProgramming;

import java.util.Arrays;

public class KnapsackProblem {

    static int ans;
    static int dp[][];

    public static int knapSack(int W, int weight[], int value[]) {
        ans = Integer.MIN_VALUE;
        dp = new int[W + 1][weight.length + 1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        ans = Math.max(check(W, weight, value, weight.length, 0), ans);
        return ans;
    }

    private static int check(int W, int[] weight, int[] value, int length, int i) {
        if (i == length || W == 0) return 0;
        if (dp[W][i] != -1) return dp[W][i];
        int ans = check(W, weight, value, length, i + 1);
        if (weight[i] <= W) {
            ans = Math.max(value[i] + check(W - weight[i], weight, value, length, i + 1), ans);
        }
        dp[W][i] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int val[] = new int[]{92, 57, 49, 68, 60, 43, 67, 84, 87, 72};
        int wt[] = new int[]{23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        int W = 165;
        int n = val.length;
        System.out.println(knapSack(W, wt, val));
        int testAns = 0;
        int optimalSelection[] = {1, 1, 1, 1, 0, 1, 0, 0, 0, 0};
        for (int i = 0; i < optimalSelection.length; i++) {
            if (1 == optimalSelection[i]) {
                testAns += val[i];
            }
        }
        System.out.println(testAns);
    }
}
