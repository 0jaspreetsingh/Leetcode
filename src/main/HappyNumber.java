package main;

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/

public class HappyNumber {

	public boolean isHappy(int n) {

		if (n == 1 || n == 7) {
			return true;
		}

		int sum = n;
		int x = n;

		while (sum > 9) {
			sum = 0;

			while (x > 0) {
				int d = x % 10;
				sum += d * d;
				x = x/10;
			}
			x  = sum;
			if(sum==7||sum==1) {
				return true;
			}
		}

		return false;
	}

	public static void main(String args[]) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(13));
	}

}
