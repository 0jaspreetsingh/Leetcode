package main;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 * 
 * @author jaspreetsingh03
 *
 */
public class SubArrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int size = nums.length;
		int arr[][] = new int[size][size];
		
		for(int i=0;i<size;i++) {
			arr[i][i] = nums[i];
		}


        return 0;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 5, 2, 6 };
		int k = 100;
		SubArrayProductLessThanK sk = new SubArrayProductLessThanK();
		System.out.println(sk.numSubarrayProductLessThanK(nums, k));
	}
}
