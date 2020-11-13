package DynamicProgramming;

public class TargetSum {

    int ans = 0;

    public int findTargetSumWays(int[] nums, int S) {
        check(nums, S, 0, 0);
        return ans;
    }

    private void check(int[] nums, int S, int index, int currentSum) {
        if (index == nums.length) {
            if (currentSum == S) {
                ans++;
            }
            return;
        }

        check(nums, S, index + 1, currentSum + nums[index]);
        check(nums, S, index + 1, currentSum - nums[index]);
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int nums[] = {1, 1, 1, 1, 1}, S = 3;
        System.out.println(ts.findTargetSumWays(nums, S));
    }
}
