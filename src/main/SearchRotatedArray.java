package main;

/**
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchRotatedArray {

    // optimized way
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (!isBinarySearchHelpful(nums, left, nums[mid])) {
                left++;
                continue;
            }

            boolean pivotArray = existsInFirst(nums, left, nums[mid]);
            boolean targetArray = existsInFirst(nums, left, target);

            if (pivotArray ^ targetArray) {
                if (pivotArray) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {
                // exists in same array
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }


        }
        return false;
    }

    private boolean isBinarySearchHelpful(int nums[], int start, int target) {
        return nums[start] != target;
    }

    private boolean existsInFirst(int nums[], int start, int target) {
        return (nums[start] <= target);
    }


    // My Way
    //****************************************************
    public boolean searchNotOptimized(int[] nums, int target) {
        int len = nums.length;
        int pivot = -1;
        loop:
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break loop;
            }
        }

        if (pivot == -1) {
            return binarySearch(nums, 0, len - 1, target);
        } else {
            return binarySearch(nums, 0, pivot, target) || binarySearch(nums, pivot + 1, len - 1, target);
        }
    }

    private boolean binarySearch(int arr[], int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    //****************************************************

    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 0, 0, 1, 2}, target = 3;
        SearchRotatedArray sra = new SearchRotatedArray();
        System.out.println(sra.search(arr, target));
    }
}
