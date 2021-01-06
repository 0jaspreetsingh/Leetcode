package arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    // nums = [2,0,2,1,1,0]

    public void sortColors(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[zero];
                nums[zero] = 0;
                zero++;
            }
        }
        int two = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                nums[i] = nums[two];
                nums[two] = 2;
                two--;
            }
        }


        //one pass
//        int j = 0, k = nums.length - 1;
//        for (int i = 0; i <= k; i++) {
//            if (nums[i] == 0) {
//                nums[i] = nums[j];
//                nums[j++] = 0;
//
//            } else if (nums[i] == 2) {
//                nums[i--] = nums[k];
//                nums[k--] = 2;
//            }
//
//        }
    }
}
