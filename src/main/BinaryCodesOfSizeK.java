package main;

import java.util.HashSet;

// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

public class BinaryCodesOfSizeK {

	public boolean hasAllCodes(String s, int k) {
		 int totalPossibleCombinations = 1<<k;   // same as writing math.pow(2,k) i.e 2^k combinations exists
		 HashSet<String> hs = new HashSet<String>();
		 
		 for(int i=0;i<=s.length()-k;i++) {
			 String str = s.substring(i,i+k);
			 if(!hs.contains(str)) {
				 hs.add(str);
			 }
			 if(hs.size()==totalPossibleCombinations) {
				 return true;
			 }
		 }
	        
		 
		 return false;
	    }

	public static void main(String[] args) {
		BinaryCodesOfSizeK bk = new BinaryCodesOfSizeK();
		System.out.println(bk.hasAllCodes("00110110", 2));
	}

}
