package techniques;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberThree {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        xor = xor & (-xor);
        int ans[] = {0, 0};
        for (int i : nums) {
            if ((xor & i) == 0) {
                ans[0] ^= i;
            } else {
                ans[1] ^= i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumberThree sn = new SingleNumberThree();
        int nums[] = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(sn.singleNumber(nums)));
    }
}
