package arrays;

/**
 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */
public class AntsArray {

    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < left.length; i++) {
            leftMax = Math.max(leftMax, left[i]);
        }
        for (int i = 0; i < right.length; i++) {
            rightMax = Math.max(rightMax, n - right[i]);
        }
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        AntsArray aa = new AntsArray();
        int n = 4, left[] = {4, 3}, right[] = {0, 1};
        System.out.println(aa.getLastMoment(n, left, right));
    }
}
