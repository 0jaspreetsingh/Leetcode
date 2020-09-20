package BiweeklyContest35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 1589. Maximum Sum Obtained of Any Permutation
 * https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
 */
public class MaxSumAnyPremutation {

    int mod = 1000000007;

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        int numOfRequests = requests.length;
        int len = nums.length;
        int arr[] = new int[len];
        for (int req[] : requests) {
            arr[req[0]]++;
            if (req[1] + 1 < len) {
                arr[req[1] + 1]--;
            }
        }

        for (int i = 1; i < len; i++) {
            arr[i] = arr[i - 1];
        }

        Arrays.sort(arr);
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum = (sum + arr[i] * nums[i]) % mod;
        }


        return sum;
    }

    // a little lengthy solution
    public int maxSumRangeQueryLengthy(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        int numOfRequests = requests.length;
        int len = nums.length;
        int arr[] = new int[len];
        for (int req[] : requests) {
            arr[req[0]]++;
            if (req[1] + 1 < len) {
                arr[req[1] + 1]--;
            }
        }

        HashMap<Integer, Integer> hs = new HashMap<>();
        int curr = 0;
        for (int i = 0; i < len; i++) {
            curr += arr[i];
            if (curr > 0) {
                hs.put(curr, hs.getOrDefault(curr, 0) + 1);
            }
        }

        int sum = 0;

        int pointer = len - 1;
        for (int i = numOfRequests; i >= 1; i--) {
            if (pointer < 0) {
                return sum;
            }
            if (hs.containsKey(i)) {
                int val = hs.get(i);
                while (val > 0) {
                    sum += i * nums[pointer];
                    sum = sum % mod;
                    pointer--;
                    val--;
                }
            }
        }


        return sum;
    }
//***************************


    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 10}, requests[][] = {{0, 2}, {1, 3}, {1, 1}};
        MaxSumAnyPremutation ms = new MaxSumAnyPremutation();
        System.out.println(ms.maxSumRangeQuery(nums, requests));
    }
}
