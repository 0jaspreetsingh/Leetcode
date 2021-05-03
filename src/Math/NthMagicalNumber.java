package Math;

/**
 * https://leetcode.com/problems/nth-magical-number/
 */
public class NthMagicalNumber {

    final int MOD = 1_000_000_007;

    public int nthMagicalNumber(int n, int a, int b) {
        int aa, bb;
        if (a <= b) {
            aa = a;
            bb = b;
        } else {
            aa = b;
            bb = a;
        }
        int lcm = (aa * bb) / gcd(aa, bb);

        int M = (lcm / aa) + (lcm / bb) - 1;

        int q = n / M, r = n % M;

        long ans = (long) q * lcm % MOD;
        if (r == 0) return (int) (ans % MOD);

        int arr[] = new int[]{aa, bb};

        for (int i = 0; i < r - 1; i++) {
            if (arr[0] <= arr[1]) {
                arr[0] += aa;
            } else {
                arr[1] += bb;
            }
        }
        ans += Math.min(arr[0], arr[1]);

        return (int) (ans % MOD);
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
