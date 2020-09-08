package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/solution/
 */
public class MaxLenOfPairChain {

    public int findLongestChain(int[][] pairs) {
        int counter = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int curr = Integer.MIN_VALUE;
        for (int pair[] : pairs) {
            if (curr < pair[0]) {
                curr = pair[1];
                counter++;
            }
        }


        return counter;
    }

    public static void main(String[] args) {
        MaxLenOfPairChain ml = new MaxLenOfPairChain();
        int arr[][] = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(ml.findLongestChain(arr));
    }
}
