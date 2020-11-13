package DepthFirstSearch;

public class OddSum {

    int mod = 1000000000 + 7;

//    public int numOfSubarrays(int[] arr) {
//        int len = arr.length;
//        int counter = 0;
//        int dp[][] = new int[len][len];
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if (i==j){
//                    dp[i][j] = arr[i];
//                }else {
//                    dp[i][j] = dp[i][j-1] + arr[j];
//                }
//                if (dp[i][j]%2!=0){
//                    counter++;
//                    counter%=mod;
//                }
//            }
//        }
//        return counter;
//    }

    public int numOfSubarrays(int[] arr) {
        int counter = 0, odd = 0, even = 1, currSum = 0;
        for (int i : arr) {
            currSum += i;
            if (currSum % 2 == 0) {
                counter = (counter + odd) % mod;
                even++;
            } else {
                counter = (counter + even) % mod;
                odd++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        OddSum os = new OddSum();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(os.numOfSubarrays(arr));
    }
}
