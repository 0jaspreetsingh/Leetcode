package techniques;

/**
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 */
public class ConcatBinaryNumbers {

    long MOD = 1000_000_007;

    public int concatenatedBinary(int n) {

        long ans = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {

            int num = i;

            if ((i & (i - 1)) == 0) len++;

            ans = ((ans << len) | i) % MOD;

        }


        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        ConcatBinaryNumbers cc = new ConcatBinaryNumbers();
        System.out.println(cc.concatenatedBinary(12));
    }
}
