package BiweeklyContest35;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * 1590. Make Sum Divisible by P
 * https://leetcode.com/problems/make-sum-divisible-by-p/
 */
public class MaxSumDivisibleByP {

    public int minSubarray(int[] nums, int p) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int len = nums.length;
        long sum1 = 0;
        for (int i = 0; i < len; i++) {
            sum1 += nums[i];
            //sum1= sum1%p;
            hs.put(nums[i], i);
        }
        if (sum1 % p == 0) {
            return 0;
        }

        int temp = (int) (sum1 % p);

        if (hs.containsKey(temp)) {
            return 1;
        }

        long tempans = sum1;

        for (int i = 2; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums[j];
            }
            if (sum == temp) {
                return i;
            }
            if (i == 7) {
                System.out.println(sum);
            }

            for (int j = 0; j < nums.length - i; j++) {

                sum -= nums[j];
                sum += nums[i + j];
                if (i == 7) {
                    System.out.println(sum);
                }
                //System.out.println(tempans);
                if ((tempans - sum) % p == 0) {
                    return i;
                }

            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2};
        int p = 148;
        MaxSumDivisibleByP pp = new MaxSumDivisibleByP();
        System.out.println(pp.minSubarray(arr, p));
    }
}
