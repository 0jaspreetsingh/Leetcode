package arrays;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 */
public class CountNumberofNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int curr = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i] % 2;
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);
            ans += hm.getOrDefault(curr - k, 0);
        }

        return ans;

    }
}
