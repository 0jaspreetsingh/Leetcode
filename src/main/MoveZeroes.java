package main;

import java.util.Arrays;

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/

public class MoveZeroes {

	public void moveZeroes(int[] nums) {

		int p1 = 0;

		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0) {
				nums[p1] = nums[i];
				p1++;
			}
		}
		
		while(p1<nums.length) {
			nums[p1] = 0;
			p1++;
		}
		
		//System.out.println(Arrays.toString(nums));

	}

	public static void main(String args[]) {
		MoveZeroes dc = new MoveZeroes();
		int nums[] = { 0, 1, 0, 3, 12 };
		dc.moveZeroes(nums);
		// System.out.println(dc.MoveZeroes(nums));
	}

}
