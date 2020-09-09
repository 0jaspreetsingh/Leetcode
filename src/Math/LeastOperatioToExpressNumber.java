package Math;

/**
 * todo
 * https://leetcode.com/problems/least-operators-to-express-number/
 */
public class LeastOperatioToExpressNumber {

    public int leastOpsExpressTarget(int x, int target) {
        int op = 0;

        int currentNo = x;

        while (currentNo != target) {


        }

        return op;
    }

    public static void main(String[] args) {
        LeastOperatioToExpressNumber lo = new LeastOperatioToExpressNumber();
        System.out.println(lo.leastOpsExpressTarget(5, 501));
    }
}
