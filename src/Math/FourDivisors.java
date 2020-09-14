package Math;

/**
 * https://leetcode.com/problems/four-divisors/submissions/
 */
public class FourDivisors {

    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        int jj = 0;
        int cc = 0;
        for (int i : nums) {
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    cc++;
                    jj = j;
                }
            }
            if (cc == 1 && i / jj != jj) {
                ans = ans + i + jj + i / jj + 1;
            }
            jj = 0;
            cc = 0;
        }
        return ans;

    }

    public static void main(String[] args) {
        FourDivisors fd = new FourDivisors();
        int nums[] = {21, 4, 7};
        System.out.println(fd.sumFourDivisors(nums));
    }
}
