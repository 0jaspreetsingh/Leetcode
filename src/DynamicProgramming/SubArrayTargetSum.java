package DynamicProgramming;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/discuss/780882/Java-14-lines-Greedy-PrefixSum-with-line-by-line-explanation-easy-to-understand
 */
public class SubArrayTargetSum {


    public int maxNonOverlapping(int[] nums, int target) {

        int prevRightMostIndex = -1, ansCount = 0, prefixSum = 0;
        //********sum*****index***
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (hm.containsKey(prefixSum - target) && hm.get(prefixSum - target) >= prevRightMostIndex) {
                ansCount++;
                prevRightMostIndex = i;
            }
            hm.put(prefixSum, i);
        }
        return ansCount;
    }


    public static void main(String[] args) {
        SubArrayTargetSum stg = new SubArrayTargetSum();
        int nums[] = {1, 1, 1, 1, 1}, target = 2;
        System.out.println(stg.maxNonOverlapping(nums, target));
    }
}
