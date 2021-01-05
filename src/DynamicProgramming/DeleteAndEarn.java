package DynamicProgramming;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/delete-and-earn/
 */
public class DeleteAndEarn {


    public int deleteAndEarn(int[] nums) {
        int hm[] = new int[10001];
        for (int i : nums) {
            hm[i]++;
        }
        int avoid = 0, using = 0, prev = -1;
        for (int i = 0; i <= 10000; i++) {
            if (hm[i] > 0) {
                int max = Math.max(avoid, using);
                if (i - 1 != prev) {
                    using = hm[i] * i + max;
                } else {
                    using = hm[i] * i + avoid;
                }
                avoid = max;
                prev = i;
            }

        }
        return Math.max(avoid, using);
    }
}
