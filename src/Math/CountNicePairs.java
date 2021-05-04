package Math;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/
 */
public class CountNicePairs {

    int MOD = 1_000_000_007;

    public int countNicePairs(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int i : nums) {
            int val = i - rev(i);
            if (hm.containsKey(val)) {
                ans += hm.get(val);
                ans = ans % MOD;
            }
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }

        return ans;
    }

    private int rev(int n) {
        int num = 0;
        while (n != 0) {
            num = num * 10 + n % 10;
            n /= 10;
        }
        return num;
    }
}
