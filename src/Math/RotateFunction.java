package Math;

/**
 * https://leetcode.com/problems/rotate-function/
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int f = 0, sum = 0, len = A.length;
        for (int i = 0; i < len; i++) {
            f += i * A[i];
            sum += A[i];
        }
        int max = f;
        for (int i = len - 1; i >= 1; i--) {
            f = f + sum - len * A[i];
            max = Math.max(max, f);
        }

        return max;
    }

}
