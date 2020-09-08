package Math;

/**
 * https://leetcode.com/problems/broken-calculator/
 */
public class BrokenCalculator {

    public int brokenCalc(int X, int Y) {
        int counter = 0;
        while (Y > X) {
            counter++;
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
        }

        int ans = counter + X - Y;

        return ans;
    }

    public static void main(String[] args) {
        BrokenCalculator br = new BrokenCalculator();
        System.out.println(br.brokenCalc(12, 25));
    }
}
