package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> hm.get(o1) - hm.get(o2));

        for (int i : hm.keySet()) {
            heap.add(i);
            if (heap.size() > k) heap.poll();
        }
        int ans[] = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
