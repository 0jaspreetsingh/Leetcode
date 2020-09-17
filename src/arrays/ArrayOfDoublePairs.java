package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/array-of-doubled-pairs/
 */
public class ArrayOfDoublePairs {
    public boolean canReorderDoubled(int[] A) {
        Integer arr[] = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }

        Arrays.sort(arr, Comparator.comparingInt(Math::abs));
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i : A) {
            hs.put(i, hs.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {

            int temp = hs.get(arr[i]);
            if (temp > 0) {
                if (hs.containsKey(arr[i] * 2) && hs.get(arr[i] * 2) > 0) {
                    hs.put(arr[i], hs.get(arr[i]) - 1);
                    hs.put(arr[i] * 2, hs.get(arr[i] * 2) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayOfDoublePairs ad = new ArrayOfDoublePairs();
        int A[] = {4, -2, 2, -4};
        System.out.println(ad.canReorderDoubled(A));
    }
}
