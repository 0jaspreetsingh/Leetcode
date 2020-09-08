package techniques;

/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class ComplimentOfBase10 {

    public int bitwiseComplementOptimized(int N) {
        // int ans = 0;
        // int base = 1;
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return 0;
        }

        int ans2 = 1;

        // similar as writing Math.pow(2,N);
        while (ans2 <= N) {
            ans2 = ans2 << 1;
        }

        return (ans2 - 1) ^ N;

    }

    public int bitwiseComplement(int N) {
        int ans = 0;
        int base = 1;
        if (N == 0) {
            return 1;
        }

        while (N != 0) {
            System.out.println(N % 2);
            int bb = (N % 2) ^ 1;
            System.out.println("Binary " + bb);
            ans += ((N % 2) ^ 1) * base;
            base *= 2;
            N /= 2;
        }
        return ans;
    }
}
