package arrays;


/**
 * https://www.youtube.com/watch?v=p5Cm_r4T1Rw
 * https://leetcode.com/problems/subarray-sums-divisible-by-k
 */
public class SubArraySumDivisibleByK {

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length, arr[] = new int[len + 1], hm[] = new int[K];
        for (int i = 1; i <= len; i++) {
            arr[i] = (arr[i - 1] + A[i - 1]) % K;
        }

        for (int i : arr) {
            hm[((i % K) + K) % K]++;
        }

        int ans = 0;

        for (int i : hm) {
            if (i > 1) {
                int combination = (i * (i - 1)) / 2;
                ans += combination;
            }
        }

        return ans;
    }
}
