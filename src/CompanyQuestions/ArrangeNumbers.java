package CompanyQuestions;

import java.util.Arrays;

public class ArrangeNumbers {

    static void middleDigit(int ar[], int n) {
        Integer[] arr = Arrays.stream(ar).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            int m1 = getMiddle(a), m2 = getMiddle(b);
            if (m1 == m2) return a - b;
            else return m1 - m2;
        });
        int ans[] = Arrays.stream(arr).mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(ans));
    }

    private static int getMiddle(int num) {
        String str = Integer.toString(num);
        return str.charAt(str.length() / 2) - '0';
    }

    public static void main(String[] args) {
        int arr[] = {10201, 30215, 90051, 36103, 92315};
        middleDigit(arr, 5);
    }
}
