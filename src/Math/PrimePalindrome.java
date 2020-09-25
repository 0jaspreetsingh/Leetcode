package Math;

import java.util.Arrays;

/**
 * todo
 * 866. Prime Palindrome
 * https://leetcode.com/problems/prime-palindrome/
 */
public class PrimePalindrome {


    public int primePalindrome(int N) {
        int magic = 20000;
        int evenAns = Integer.MAX_VALUE;
        int oddAns = Integer.MAX_VALUE;
        evenLoop:
        for (int i = N; i <= magic; i++) {
            StringBuilder str = new StringBuilder(Integer.toString(i));
            for (int j = str.length() - 1; j >= 0; j--) {
                str.append(str.charAt(j));
            }
            int num = Integer.parseInt(str.toString());
            System.out.println(num);
            if (isPrime(num)) {
                evenAns = num;
                break evenLoop;
            }
        }
        oddLoop:
        for (int i = N; i <= magic; i++) {
            StringBuilder str = new StringBuilder(Integer.toString(i));

            for (int j = str.length() - 2; j >= 0; j--) {
                str.append(str.charAt(j));

            }
            int num = Integer.parseInt(str.toString());

            if (isPrime(num)) {
                evenAns = num;
                break oddLoop;
            }
        }

        return evenAns < oddAns ? evenAns : oddAns;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PrimePalindrome pp = new PrimePalindrome();
        System.out.println(pp.primePalindrome(13));
    }
}
