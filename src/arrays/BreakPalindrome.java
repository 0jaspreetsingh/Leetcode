package arrays;

/**
 * https://leetcode.com/problems/break-a-palindrome/
 *
 */
public class BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        char arr[] = palindrome.toCharArray();
        if (arr.length <= 1) {
            return "";
        }
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }
        arr[arr.length - 1] = 'b';
        return new String(arr);
    }
}
