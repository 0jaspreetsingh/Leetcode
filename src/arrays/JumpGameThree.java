package arrays;

import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/jump-game-iii/
 */
public class JumpGameThree {
    public boolean canReach(int[] arr, int start) {
        boolean seen[] = new boolean[arr.length];
        Stack<Integer> indexes = new Stack<>();
        indexes.push(start);
        while (!indexes.isEmpty()) {
            int curr = indexes.pop();
            if (arr[curr] == 0) return true;
            seen[curr] = true;
            int back = curr - arr[curr];
            int forward = curr + arr[curr];
            if (isIndexValid(back, arr.length) && !seen[back]) {
                indexes.push(back);
            }
            if (isIndexValid(forward, arr.length) && !seen[forward]) {
                indexes.push(forward);
            }
        }
        return false;
    }

    private boolean isIndexValid(int index, int len) {
        return index >= 0 && index < len;
    }


    public static void main(String[] args) {
        int arr[] = {3, 0, 2, 1, 2}, start = 2;
        JumpGameThree jumpGameThree = new JumpGameThree();
        System.out.println(jumpGameThree.canReach(arr, start));
    }
}


