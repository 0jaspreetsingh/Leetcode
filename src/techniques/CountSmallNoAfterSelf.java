package techniques;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * todo
 */
public class CountSmallNoAfterSelf {

    // simple way
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> ls = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            int counter = 0;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] < nums[i]) {
//                    counter++;
//                }
//            }
//            ls.add(counter);
//        }
//        return ls;
//    }


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();


        return ans;
    }

    private void mergeSort(int arr[], int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int arr[], int left, int mid, int right) {
        int l = left;
        int r = mid + 1;

    }


    public static void main(String[] args) {
        CountSmallNoAfterSelf cc = new CountSmallNoAfterSelf();
        System.out.println();
    }
}
