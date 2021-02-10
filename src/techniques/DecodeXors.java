package techniques;

import java.util.*;

/**
 * biweekly
 * https://leetcode.com/problems/decode-xored-permutation/
 * https://www.youtube.com/watch?v=I5-uDlbwbOA
 */
public class DecodeXors {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1, ans[] = new int[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum ^= i;
        }
        int sumWithoutfirst = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            sumWithoutfirst ^= encoded[i];
        }
        ans[0] = sum ^ sumWithoutfirst;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        DecodeXors dc = new DecodeXors();
        int arr[] = {3, 1};
        System.out.println(Arrays.toString(dc.decode(arr)));
    }
}
