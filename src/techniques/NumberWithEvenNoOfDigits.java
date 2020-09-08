package techniques;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class NumberWithEvenNoOfDigits {

    public int findNumbers(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter += check(nums[i]);
        }
        return counter;
    }

    private int check(int num) {
        int isOdd = 1;

        while (num != 0) {
            num /= 10;
            isOdd = isOdd ^ 1;
        }

        return isOdd;

    }
}
