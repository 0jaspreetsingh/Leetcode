package main;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class MinInSortedArrayRotated {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
                left++;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        MinInSortedArrayRotated mm = new MinInSortedArrayRotated();
        int nums[] = {2, 2, 2, 0, 1};
        System.out.println(mm.findMin(nums));
    }
}
