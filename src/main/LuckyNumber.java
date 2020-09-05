package main;

public class LuckyNumber {

	public int findLucky(int[] arr) {
		int ans = -1;
		int hm[] = new int[501];  // constrain given already , otherwise would have used hashmap
		for(int i=0;i<arr.length;i++) {
			hm[arr[i]]++;
		}
		for(int i=0;i<arr.length;i++) {
			if(hm[arr[i]]==arr[i]) {
				if(ans<arr[i]) {
					ans = arr[i];
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 7, 7, 7, 7, 7, 7, 7 };
		LuckyNumber lm = new LuckyNumber();
		System.out.println(lm.findLucky(arr));
	}
}
