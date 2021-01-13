package techniques;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRoatedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        return rotatedBinarySearch(nums, left, right, target);
    }

    private int rotatedBinarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        if (left == right && nums[left] == target) return left;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        // check if left subarry is sorted
        if (nums[mid] >= nums[left]) {
            //check if target is inside this subarray or not
            if (nums[mid] >= target && nums[left] <= target) return rotatedBinarySearch(nums, left, mid - 1, target);
            else {
                return rotatedBinarySearch(nums, mid + 1, right, target);
            }
        }
        // i.e right subarray is sorted
        if (target >= nums[mid] && target <= nums[right]) return rotatedBinarySearch(nums, mid + 1, right, target);
        return rotatedBinarySearch(nums, left, mid - 1, target);
    }

//    public int search(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        int pivot = getPivot(nums, left, right);
//        System.out.println(pivot);
//        if (pivot == -1) return binarySearch(nums, left, right, target);
//        if (nums[pivot] == target) return pivot;
//        else if (nums[left] <= target) return binarySearch(nums, left, pivot - 1, target);
//        else return binarySearch(nums, pivot + 1, right, target);
//    }
//
//    private int getPivot(int[] nums, int left, int right) {
//        if (left > right) return -1;
//        int mid = (left + right) / 2;
//        if (left == right) return left;
//        else if (left < mid && nums[mid] < nums[mid - 1]) return mid - 1;
//        else if (right > mid && nums[mid] > nums[mid + 1]) return mid;
//        else if (nums[mid] <= nums[left]) return getPivot(nums, left, mid - 1);
//        else return getPivot(nums, mid + 1, right);
//    }
//
//    // simple binary search
//    private int binarySearch(int arr[], int left, int right, int element) {
//        if (left > right) return -1;
//        int mid = (left + right) / 2;
//        if (arr[mid] == element) return mid;
//        else if (arr[mid] < element) return binarySearch(arr, mid + 1, right, element);
//        else return binarySearch(arr, left, mid - 1, element);
//    }
}

