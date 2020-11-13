package DynamicProgramming;

/**
 * https://leetcode.com/problems/2-keys-keyboard/
 */
public class TwoKeyboard {

    int finalAns = Integer.MAX_VALUE;

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int arr[][] = new int[n + 1][n + 1];
        copyPaste(n, 1, 1, 1, arr);
        return finalAns;
    }

    private void copyPaste(int n, int currentValue, int copiedValue, int ans, int arr[][]) {
        if (currentValue > n) {
            return;
        }
        if (arr[currentValue][copiedValue] != 0) {
            return;
        }
        if (n == currentValue) {
            if (finalAns > ans) {
                finalAns = ans;
                arr[currentValue][copiedValue] = finalAns;
                return;
            }
        }
        //copy
        if (currentValue != copiedValue) {
            copyPaste(n, currentValue, currentValue, ans + 1, arr);
        }
        //paste
        copyPaste(n, currentValue + copiedValue, copiedValue, ans + 1, arr);
    }

    public static void main(String[] args) {
        TwoKeyboard tk = new TwoKeyboard();
        System.out.println(tk.minSteps(45));
    }
}
