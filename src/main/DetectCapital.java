package main;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/

public class DetectCapital {

	public boolean detectCapitalUse(String word) {
		int len = word.length();
		if (len == 0 || len == 1) {
			return true;
		}

		if(isCapital(word.charAt(0))&&isCapital(word.charAt(1))) {
			// all should be capital
			for(int i=1;i<word.length();i++) {
				if(!isCapital(word.charAt(i))) {
					return false;
				}
			}
		}else {
			// all should be lowercase
			for(int i=1;i<word.length();i++) {
				if(!isLowerCase(word.charAt(i))) {
					return false;
				}
			}
		}
		
		

		return true;
	}

	public boolean isCapital(char ch) {
		return ch >= 'A' && ch <= 'Z';
	}
	
	public boolean isLowerCase(char ch) {
		return ch >= 'a' && ch <= 'z';
	}

	public static void main(String[] args) {
		DetectCapital dc = new DetectCapital();
		System.out.println(dc.detectCapitalUse("FlaG"));
	}

}
