package Math;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/construct-target-array-with-multiple-sums/
 * <p>
 * better explanation here
 * https://leetcode.com/problems/construct-target-array-with-multiple-sums/discuss/510379/C%2B%2B-Backwards-reconstruction-with-max-heap.-Detailed-explanation.
 */
public class TargetArrayWithMultipleSum {

    public boolean isPossible(int[] target) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i : target) {
            sum += i;
            pq.add(i);
        }
        while (true) {
            int x = pq.poll();
            sum -= x;
            if (sum == 1 || x == 1) {
                return true;
            }
            if (sum <= 0 || x < sum || x % sum == 0) {
                return false;
            }
            x %= sum;
            sum += x;
            pq.add(x);
        }
    }

    public static void main(String[] args) {
        TargetArrayWithMultipleSum tc = new TargetArrayWithMultipleSum();
        int arr[] = {9, 3, 5};
        System.out.println(tc.isPossible(arr));
    }
}
