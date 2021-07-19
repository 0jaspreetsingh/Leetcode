package CompanyQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MaximumSubarray {

    public static int sol(int[] arr, int m) {
        int answer = 0, prefixSumSoFar = 0;
        HashSet<Integer> hashSet = new HashSet<Integer>() {{
            add(0);
        }};

        for (int i = 0; i < arr.length; i++) {
            prefixSumSoFar = (prefixSumSoFar + arr[i]) % m;
            answer = Math.max(prefixSumSoFar, answer);

            int iterator = 0;
            for (int hashSetVal : hashSet) {
                if (hashSetVal >= prefixSumSoFar + 1) {
                    iterator = hashSetVal;
                }
            }
            if (iterator != 0) {
                answer = Math.max(answer, (prefixSumSoFar - iterator + m) % m);
            }
            hashSet.add(prefixSumSoFar);
        }

        return answer;
    }

    static int maxSubarray(int[] arr, int n, int m) {
        int prefix = 0;
        int maxim = 0;
        Set<Integer> S = new HashSet<Integer>();
        S.add(0);

        // Traversing the array.
        for (int i = 0; i < n; i++) {

            // Finding prefix sum.
            prefix = (prefix + arr[i]) % m;

            // Finding maximum of prefix sum.
            maxim = Math.max(maxim, prefix);

            // Finding iterator poing to the first
            // element that is not less than value
            // "prefix + 1", i.e., greater than or
            // equal to this value.
            int it = 0;

            for (int j : S) {
                if (j >= prefix + 1)
                    it = j;
            }
            if (it != 0) {
                maxim = Math.max(maxim, prefix - it + m);
            }

            // adding prefix in the set.
            S.add(prefix);
        }
        return maxim;
    }

    static void sort(String a[], int n) {

        //sort the array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // comparing which of the
                // two concatenation causes
                // lexiographically smaller
                // string
                if ((a[i] + a[j]).compareTo(a[j] + a[i]) > 0) {
                    String s = a[i];
                    a[i] = a[j];
                    a[j] = s;
                }
            }
        }
    }

    static String lexsmallest(String a[]) {

        Arrays.sort(a, (str1, str2) -> {
            return (str1 + str2).compareTo(str2 + str1);
        });
        StringBuilder answer = new StringBuilder();
        for (String str : a)
            answer.append(str);

        return answer.toString();
    }

    static boolean areBracketsBalanced(String expr) {
        Stack<Character> stack = new Stack<Character>();

        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char right = stack.pop();
                if (right == ')' && ch != '(') return false;
                else if (right == ']' && ch != '[') return false;
                else if (right == '}' && ch != '{') return false;
            }

        }
        return true;
    }

    static int countSwap(String str) {
        int length = str.length();

        char array[] = str.toCharArray();

        int counter = 0;
        for (int i = 0; i < length / 2; i++) {

            int left = i;

            int right = length - left - 1;

            while (left < right) {

                if (array[left] == array[right]) {
                    break;
                } else {
                    right--;
                }
            }

            if (left == right) {
                return -1;
            } else if (array[left] != array[length - left - 1]) {
                char temp = array[right];
                array[right] = array[length - left - 1];
                array[length - left - 1] = temp;
                counter++;
            }
        }

        return counter;
    }


    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int arr[] = {3, 3, 9, 9, 5}, m = 7;
        System.out.println(ms.sol(arr, 7));

        String a[] = {"a", "bd", "ac", "cd"};
        int n = 4;
        System.out.println("lexiographically smallest string = "
                + lexsmallest(a));
    }
}
