package Greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/most-profit-assigning-work/
 */
public class MostProfitAssignedWork {

    class Work {
        int difficulty;
        int profit;

        Work(int profit, int difficulty) {
            this.profit = profit;
            this.difficulty = difficulty;
        }

        @Override
        public String toString() {
            return "profit: " + profit + " difficulty: " + difficulty;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int size = difficulty.length;
        Work[] workList = new Work[size];
        for (int i = 0; i < size; i++) {
            workList[i] = new Work(profit[i], difficulty[i]);
        }
        Arrays.sort(workList, (a, b) -> b.profit - a.profit);
        Arrays.sort(worker);
        int pointer = 0;
        int ans = 0;
        forLoop:
        for (int i = worker.length - 1; i >= 0; i--) {
            while (workList[pointer].difficulty > worker[i]) {
                pointer++;
                if (pointer >= size) {
                    break forLoop;
                }
            }
            ans += workList[pointer].profit;
        }
        System.out.println(Arrays.toString(workList));
        return ans;
    }

    /**
     * approach used
     * Computing maximum profit which we can get with a given difficulty before instead of sorting
     *
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignmentWithDP(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        int minDifficulty = Integer.MAX_VALUE;
        int maxDifficulty = 0;
        for (int d : difficulty) {
            minDifficulty = Math.min(minDifficulty, d);
            maxDifficulty = Math.max(maxDifficulty, d);
        }
        int dp[] = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.length; i++) {
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
        }
        for (int i = minDifficulty + 1; i <= maxDifficulty; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        for (int w : worker) {
            ans += w > maxDifficulty ? dp[maxDifficulty] : dp[w];
        }
        return ans;
    }


    public static void main(String[] args) {
        MostProfitAssignedWork mostProfitAssignedWork = new MostProfitAssignedWork();
        int difficulty[] = {85, 47, 57}, profit[] = {24, 66, 99}, worker[] = {40, 25, 25};
        System.out.println(mostProfitAssignedWork.maxProfitAssignmentWithDP(difficulty, profit, worker));
    }
}
