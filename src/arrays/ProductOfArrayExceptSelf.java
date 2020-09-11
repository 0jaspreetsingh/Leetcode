package arrays;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;

        int ans[] = new int[len];

        ans[0] = 1;

        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int right = 1;

        for (int i = len - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = nums[i] * right;
        }
        return ans;
    }
}
