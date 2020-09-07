package arrays;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * https://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/
 */
public class MinMovesToMakeElementsEqual {

    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i : nums) {
            min = Math.min(min, i);
            sum += i;
        }
        return sum - min * n;
    }

    public static void main(String[] args) {
        MinMovesToMakeElementsEqual mm = new MinMovesToMakeElementsEqual();
        int arr[] = {1, 2, 3};
        System.out.println(mm.minMoves(arr));
    }
}
