package PriorityQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointstoOrigin {

    class node {
        int val;
        int index;

        node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<node> pq = new PriorityQueue(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.val - o2.val;
            }
        });
        HashMap<Integer, Integer> hs = new HashMap();
        for (int i = 0; i < points.length; i++) {
            int val = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new node(val, i));
        }
        int ans[][] = new int[K][2];
        for (int i = 0; i < K; i++) {
            int index = pq.poll().index;
            ans[i][0] = points[index][0];
            ans[i][1] = points[index][1];
        }
        return ans;
    }
}
