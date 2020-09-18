package codeChef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/PERMPAL
 */
public class PermutationPalindrome {

    private void computeAns(String str) {
        char arr[] = str.toCharArray();
        if (arr.length == 0) {
            System.out.println("-1");
            return;
        }
        if (arr.length == 1) {
            System.out.println("1");
            return;
        }

        int a[] = new int[26];
        for (char c : arr) {
            a[c - 'a']++;
        }
        int counter = 0;
        char oddChar = '$';
        for (char c : arr) {
            if (a[c - 'a'] % 2 != 0) {
                oddChar = c;
                counter++;
                a[c - 'a'] = 0;
            }
            if (counter > 1) {
                System.out.println("-1");
                return;
            }
        }

        char temp[] = str.toCharArray();
        int len = temp.length;
        int ans[] = new int[len];
        int start = 0;

        if (oddChar != '$') {
            for (int i = 0; i < len; i++) {
                if (temp[i] == oddChar) {
                    ans[len / 2] = i + 1;
                    temp[i] = '$';
                    break;
                }
            }
        }

        for (int i = 0; i < len / 2; i++) {
            char chosen = '$';
            innerloop:
            for (int j = start; j < len; j++) {
                if (temp[j] != '$') {
                    ans[i] = j + 1;
                    chosen = temp[j];
                    temp[j] = '$';
                    start = j + 1;
                    break innerloop;
                }
            }
            if (chosen == '$') {

                System.out.println("-1");
                return;
            }
            innerloop2:
            for (int j = start; j < len; j++) {
                if (temp[j] == chosen) {
                    ans[len - i - 1] = j + 1;
                    temp[j] = '$';
                    break innerloop2;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    private int find(char[] temp) {
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= 'a' && temp[i] <= 'z') {
                temp[i] = '$';
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        PermutationPalindrome pp = new PermutationPalindrome();
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.next());
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = s.next();
        }
        for (String str1 : str) {
            pp.computeAns(str1);
        }

    }
}
