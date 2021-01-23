package DynamicProgramming;

/**
 * https://en.wikipedia.org/wiki/Catalan_number
 * https://leetcode.com/problems/unique-binary-search-trees/
 * https://www.youtube.com/watch?v=0s20L4-chDA
 */
public class UniqueBinaryTrees {
    public int numTrees(int n) {
        int ansArr[] = new int[n + 1];
        ansArr[0] = ansArr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ansArr[i] += ansArr[j - 1] * ansArr[i - j];
            }
        }
        return ansArr[n];
    }

    public static void main(String[] args) {
        UniqueBinaryTrees uq = new UniqueBinaryTrees();
        System.out.println(uq.numTrees(4));
    }

}
