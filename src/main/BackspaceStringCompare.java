package main;

// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/

public class BackspaceStringCompare {

	public boolean backspaceCompare(String S, String T) {

		int p1 = S.length() - 1;
		int p2 = T.length() - 1;

		int hsf1 = 0;
		int hsf2 = 0;

		while (p1 >= 0 && p2 >= 0) {

			// System.out.println(p1 + " " + p2);

			if (S.charAt(p1) == '#') {
				hsf1++;
				p1--;
			} else if (hsf1 > 0) {
				hsf1--;
				p1--;
			} else if (T.charAt(p2) == '#') {
				hsf2++;
				p2--;
			} else if (hsf2 > 0) {
				hsf2--;
				p2--;
			} else if (S.charAt(p1) == T.charAt(p2)) {
				p1--;
				p2--;
			} else {
				return false;
			}
		}
		if (p1 >= 0) {
			while (p1 >= 0) {
				if (S.charAt(p1) == '#') {
					hsf1++;
					p1--;
				} else if (hsf1 > 0) {
					hsf1--;
					p1--;
				} else {
					return false;
				}
			}
		}

		if (p2 >= 0) {
			while (p2 >= 0) {
				if (T.charAt(p2) == '#') {
					hsf2++;
					p2--;
				} else if (hsf2 > 0) {
					hsf2--;
					p2--;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String args[]) {
		BackspaceStringCompare dc = new BackspaceStringCompare();
		String S = "y#fo##f";
		String T = "y#fx#0##f";
		System.out.println(dc.backspaceCompare(S, T));
	}
}
