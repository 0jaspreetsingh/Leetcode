package arrays;

/**
 * https://leetcode.com/problems/car-pooling/submissions/
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int cap[] = new int[1001];
        for (int trip[] : trips) {
            cap[trip[1]] += trip[0];
            cap[trip[2]] -= trip[0];
        }
        int usedCap = 0;
        for (int tempCap : cap) {
            usedCap += tempCap;
            if (usedCap > capacity) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CarPooling cp = new CarPooling();
        int arr[][] = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(cp.carPooling(arr, capacity));
    }

}
