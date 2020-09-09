package Math;

/**
 * https://leetcode.com/problems/super-palindromes/submissions/
 */
public class SuperPalindrome {
// Time Limit Exceed
//    public int superpalindromesInRange(String L, String R) {
//        int counter = 0;
//        //generate all combination
//        long left = Long.parseLong(L);
//        long right = Long.parseLong(R);
//
//        for (long l = (long)Math.sqrt(left);l<=(long)Math.sqrt(right);l++){
//            if (isPalindrome(l)&&isPalindrome(l*l)){
//                System.out.println(l);
//                counter++;
//            }
//        }
//        return counter;
//    }

    public int superpalindromesInRange(String L, String R) {
        int counter = 0;
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        int magic = 100000;
        // palindrome with even no of digits
        evenLoop:
        for (int i = 1; i <= magic; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 1; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            long num = Long.parseLong(sb.toString());
            num *= num;
            if (num >= l && num <= r && isPalindrome(num)) {
                counter++;
            }
            if (num > r) {
                break evenLoop;
            }
        }

        oddLoop:
        for (int i = 1; i <= magic; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 2; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            long num = Long.parseLong(sb.toString());
            num *= num;
            if (num >= l && num <= r && isPalindrome(num)) {
                counter++;
            }
            if (num > r) {
                break oddLoop;
            }
        }

        return counter;
    }


    private boolean isPalindrome(long d) {
        String str = Long.toString(d);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        SuperPalindrome sp = new SuperPalindrome();
        System.out.println(sp.superpalindromesInRange("4", "1000"));
        //System.out.println(sp.isPalindrome("1"));
    }
}
