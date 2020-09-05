package main;

// https://leetcode.com/problems/trapping-rain-water/

public class TrapWater {

	public int trap(int[] height) {
		int len = height.length;
		if(len==0) {
			return 0;
		}
		
		int water = 0;
		int left[] = new int[len];
		int right[] = new int[len];

		left[0] = height[0];
		for (int i = 1; i < len; i++) {
			if(height[i]>left[i-1]) {
				left[i] = height[i];
			}else {
				left[i] = left[i-1];
			}
		}
		
		right[len-1] = height[len-1];
		
		for (int j = len-2; j >=0; j--) {
			if(height[j]>right[j+1]) {
				right[j] = height[j];
			}else {
				right[j] = right[j+1];
			}
		}
		
		for(int k=0;k<len;k++) {
			water = water + Math.min(left[k], right[k]) - height[k];
		}

		return water;
	}

	public static void main(String[] args) {
		TrapWater tw = new TrapWater();
		int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(tw.trap(height));
	}

}
