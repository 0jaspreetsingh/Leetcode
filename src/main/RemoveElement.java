package main;

import java.util.Arrays;

/**
 * 
 * @author jaspreetsingh03
 *
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int p = 0;
		int len = 0;
		
		while(len<nums.length){
			if(nums[len]!=val) {
				nums[p] = nums[len];
				p++;
			}
			len++;
		}
		
		
		return p;
	}

	public static void main(String[] args) {
		RemoveElement rem = new RemoveElement();
		int nums[] = { 3, 2, 2, 3 };
		int val = 3;
		System.out.println(rem.removeElement(nums, val));
		System.out.println(Arrays.toString(nums));
	}
}
