package main;

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/

public class MaxSubArray {

	public int maxSubArray(int[] nums) {
		int maxSoFar = nums[0];
		int maxEnd = nums[0];

		for (int i = 1; i < nums.length; i++) {
			maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
			maxEnd = Math.max(maxEnd, maxSoFar);
		//	System.out.println(maxSoFar+" "+maxEnd);
		}

		return maxEnd;
	}

	public static void main(String args[]) {
		MaxSubArray dc = new MaxSubArray();
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(dc.maxSubArray(nums));
	}
}
