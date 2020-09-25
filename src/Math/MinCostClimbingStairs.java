package Math;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int t1 = 0, t2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int t0 = cost[i] + Math.min(t1, t2);
            t2 = t1;
            t1 = t0;
        }

        return Math.min(t1, t2);
    }


    public static void main(String[] args) {
        MinCostClimbingStairs ms = new MinCostClimbingStairs();
        int cost[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(ms.minCostClimbingStairs(cost));
    }
}

