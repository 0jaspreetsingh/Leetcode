package main;

import java.util.*;

/**
 * unsolved
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class FindSmallestKPair {


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int ind1 = 0;
        int ind2 = 0;

        List<List<Integer>> ans = new ArrayList();
        int totalCom = nums1.length * nums2.length;
        k = Math.min(totalCom, k);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums1[i]);
                temp.add(nums2[j]);
                ans.add(temp);
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        FindSmallestKPair fk = new FindSmallestKPair();
        int nums1[] = {1, 7, 11}, nums2[] = {2, 4, 6}, k = 10;
        System.out.println(fk.kSmallestPairs(nums1, nums2, k));
    }
}
