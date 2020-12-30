package techniques;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 */
public class LeastNoOfUniqueIntegers {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        for (int i : hm.keySet()) {
            pq.add(hm.get(i));
        }
        int ans = hm.size();

        while (k > 0) {
            int val = pq.poll();
            if (val <= k) {
                ans--;
            }
            k -= val;

        }
        return ans;
    }

    //from leet code
// instead of using priority queue, can also use another array and eleminate elements on the basis of their occourence
    public int findLeastNumOfUniqueIntsLeetCodeSolution(int[] arr, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int num : arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int[] occuranceCount = new int[arr.length + 1];
        for (int c : count.values()) {
            occuranceCount[c]++;
        }
        int remain = count.size();
        int occurance = 1;
        while (k > 0) {
            if (k - occurance * occuranceCount[occurance] >= 0) {
                k -= occurance * occuranceCount[occurance];
                remain -= occuranceCount[occurance++];
            } else {
                return remain - k / occurance;
            }
        }
        return remain;
    }
}
