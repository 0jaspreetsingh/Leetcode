package main;
///  https://leetcode.com/problems/string-to-integer-atoi/

public class StringtoInteger {

	public int myAtoi(String str) {
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		long num = 0;
		boolean isNeg = false;
		int start = 0;

		if (str.charAt(0) == '-') {
			isNeg = true;
			start = 1;
		} else if (str.charAt(0) == '+') {
			start = 1;
		}

		loop: for (int i = start; i < str.length(); i++) {

			char temp = str.charAt(i);
			System.out.println(temp);

			if (temp >= '0' && temp <= '9') {
				int val = temp - '0';
				
				if (isNeg) {
					num = num * 10 - val;
				}else {
					num = num * 10 + val;
				}

				if (num <= Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
				if (num >= Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}

			} else {
				break loop;
			}
		}

		int ans = (int) num;
		return ans;
	}

	public static void main(String args[]) {
		StringtoInteger si = new StringtoInteger();
		System.out.println(si.myAtoi("   -42"));
	}

}
