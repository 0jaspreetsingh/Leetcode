package main;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/

public class SingleNumber {

	public int singleNumber(int[] nums) {
		int len = nums.length;
		if(len==1)return nums[0];
		for (int i = 1; i < len; i++) {
			nums[i] = nums[i-1]^nums[i];
		}
		return nums[len-1];
	}

	public static void main(String args[]) {

		int arr[] = { 2, 2, 1 };

		SingleNumber ss = new SingleNumber();
		System.out.println(ss.singleNumber(arr));
	}

}
