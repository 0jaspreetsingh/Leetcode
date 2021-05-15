package Greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/
 */
public class MinimumInitialEnergy {

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int ans = 0;
        for (int[] task : tasks) {
            ans = Math.max(ans + task[0], task[1]);
        }
        return ans;
    }
}
