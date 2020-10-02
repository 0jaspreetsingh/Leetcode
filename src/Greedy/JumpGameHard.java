package Greedy;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameHard {

    public int jump(int[] nums) {
        int currEnd = 0, jumps = 0, currFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = currFarthest;
            }
        }

        return jumps;
    }
}
