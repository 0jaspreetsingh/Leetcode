package Math;

import java.util.HashMap;

/**
 * todo
 * https://leetcode.com/problems/numbers-with-repeated-digits/
 */
public class NumbersWithRepeatingDigits {
    public int numDupDigitsAtMostN(int N) {

        int counter = 0;
        for (int i = 11; i <= N; i++) {
            if (check(i)) {
                counter++;
                System.out.println(i);
            }
        }

        return counter;
    }

    private boolean check(int i) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        while (i != 0) {
            hs.put(i % 10, hs.getOrDefault(i % 10, 0) + 1);
            if ((hs.getOrDefault(i % 10, 1)) % 2 == 0) {
                return true;
            }
            i = i / 10;
        }
        return false;
    }

    public static void main(String[] args) {
        NumbersWithRepeatingDigits nd = new NumbersWithRepeatingDigits();
        System.out.println(nd.numDupDigitsAtMostN(10000));
    }
}
