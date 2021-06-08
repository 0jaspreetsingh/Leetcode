package arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 */
public class CountNumberofNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
            if (nums[i] == 1) {
                q.add(i);
            }
        }
        int count = 0, left = 0, right = 0;
        int kk = 0;

        while (left <= right) {
            kk += right;
            if (kk == k) count++;
            else if (kk > k) {
                left = q.poll();
                kk--;
            } else if (right < 2) {

            }
        }
        return count;
    }
}
