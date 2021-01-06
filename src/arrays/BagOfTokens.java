package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/bag-of-tokens/
 */
public class BagOfTokens {

    // consume power and increase score from low to hight until not possible, store this score if it is hightest than
    //the previous value encountered , then consume the highest value if score is greater than 0 , and continue again

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1, score = 0, ans = 0;
        while (i <= j && (tokens[i] <= P || score > 0)) {
            while (i <= j && P >= tokens[i]) {
                P -= tokens[i++];
                score++;
            }
            ans = Math.max(ans, score);
            if (i <= j && score > 0) {
                P += tokens[j--];
                score--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        BagOfTokens bg = new BagOfTokens();
        int tokens[] = {100, 200}, P = 150;
        System.out.println(bg.bagOfTokensScore(tokens, P));
    }
}
