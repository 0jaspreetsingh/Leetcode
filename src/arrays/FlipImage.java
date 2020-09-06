package arrays;

/**
 * https://leetcode.com/problems/flipping-an-image/
 */
public class FlipImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int [] arr:A
             ) {
            flipAndInvert(arr);
        }
        return A;
    }

    private void flipAndInvert(int arr[]){
        int n = arr.length;
        for (int i=0;i<n/2;i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1]^1;
            arr[n-i-1] = temp^1;
        }
        if(n%2!=0){
            arr[n/2] = arr[n/2]^1;
        }
    }

    public static void main(String[] args) {
        FlipImage fi = new FlipImage();
        int A[][] = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println(fi.flipAndInvertImage(A));
        int a = 1;
        int b = 0;

        System.out.println(b^1);
    }
}
