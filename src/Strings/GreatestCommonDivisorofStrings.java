package Strings;

/**
 * 1071. Greatest Common Divisor of Strings
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 */
public class GreatestCommonDivisorofStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int len1 = str1.length();
        int len2 = str2.length();

        int gcd = gcd(len1, len2);
        if (len1 < len2) {
            return str1.substring(0, gcd);
        } else {
            return str2.substring(0, gcd);
        }
    }

    private int gcd(int len1, int len2) {
        if (len2 == 0) {
            return len1;
        }
        return len1 % len2 == 0 ? len2 : gcd(len2, len1 % len2);
    }


    public static void main(String[] args) {
        GreatestCommonDivisorofStrings gg = new GreatestCommonDivisorofStrings();
        System.out.println(gg.gcdOfStrings("ABABAB", "ABAB"));
    }
}
