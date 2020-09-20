package BiweeklyContest35;

/**
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 * 1588. Sum of All Odd Length Subarrays
 */
public class SumOddLength {

    public int sumOddLengthSubarraysNotOptimized(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int ans = 0;
        for (int i : arr) {
            ans += i;
        }
        if (arr.length == 2) {
            return ans;
        }

        if (arr.length % 2 != 0) {
            ans *= 2;
        }

        if (arr.length == 3) {
            return ans;
        }

        for (int i = 3; i < arr.length; i += 2) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            ans += sum;
            for (int j = 0; j < arr.length - i; j++) {

                sum -= arr[j];
                sum += arr[i + j];
                ans += sum;
                System.out.println(sum);
            }
        }

        return ans;
    }

    //*******************

    /**
     * Explained by master lee @ https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/854184/JavaC%2B%2BPython-O(N)-Time-O(1)-Space
     *
     * @param A
     * @return
     */
    public int sumOddLengthSubarrays(int[] A) {
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            ans += (((i + 1) * (A.length - i) + 1) / 2) * A[i];
        }
        return ans;
    }

    //*******************


    public static void main(String[] args) {
        SumOddLength s1 = new SumOddLength();
        int arr[] = {1, 4, 2, 5};
        System.out.println(s1.sumOddLengthSubarrays(arr));
    }
}

