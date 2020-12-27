package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinousSubArraySum {


    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }
            Integer prev = hm.get(runningSum);
            if (prev != null) {
                if ((i - prev) > 1) {
                    return true;
                }
            } else {
                hm.put(runningSum, i);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ContinousSubArraySum ss = new ContinousSubArraySum();
        int nums[] = {0, 0}, k = -1;
        System.out.println(ss.checkSubarraySum(nums, k));
    }
}
