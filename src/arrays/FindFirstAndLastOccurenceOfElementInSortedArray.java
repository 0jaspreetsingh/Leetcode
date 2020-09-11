package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastOccurenceOfElementInSortedArray {

    public int[] find(int arr[], int element) {
        int ans[] = {-1, -1};
        int x = binarySearch(arr, 0, arr.length - 1, element);
        if (x == -1) {
            return ans;
        }
        int y = binarySearch(arr, x, arr.length - 1, element + 1) - 1;
        if (x <= y) {
            ans[0] = x;
            ans[1] = y;
        }
        return ans;
    }

    private int binarySearch(int arr[], int start, int end, int element) {
        int firstIndex = arr.length;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (arr[mid] >= element) {

                firstIndex = mid;

                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return firstIndex;
    }

    public static void main(String[] args) {

        //           0  1  2  3  4  5  6  7  8  9  10
        int arr[] = {2, 3, 4, 5, 5, 5, 8, 8, 8, 8, 10};
        int element = 8;
        FindFirstAndLastOccurenceOfElementInSortedArray ff = new FindFirstAndLastOccurenceOfElementInSortedArray();
        System.out.println(Arrays.toString(ff.find(arr, element)));
    }
}