package Strings;

/**
 * https://www.geeksforgeeks.org/next-higher-palindromic-number-using-set-digits/
 */
public class NextHighestPalindrome {

    public String find(String str) {
        int len = str.length();
        char arr[] = str.toCharArray();
        if (len <= 3) return "-1";
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 1; i < len / 2; i++) {
            if (arr[maxIndex] <= arr[i]) {

            }
        }
        String ans = new String(arr);
        return ans.equals(str) ? "-1" : ans;
    }
}
