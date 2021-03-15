package arrays;

/**
 * https://leetcode.com/problems/bulb-switcher-iii/
 */
public class BulbSwitchThree {

    // nice explanation
// https://leetcode.com/problems/bulb-switcher-iii/discuss/625201/python-greater99-explained-step-by-step-basic-python-tip
    public int numTimesAllBlue(int[] light) {
        int highestBulbOn = 0;
        int bulbOnSoFar = 0, counter = 0;
        for (int i = 0; i < light.length; i++) {
            bulbOnSoFar++;
            highestBulbOn = Math.max(highestBulbOn, light[i]);
            if (highestBulbOn == bulbOnSoFar) {
                counter++;
            }
        }
        return counter;
    }

//    public int numTimesAllBlue(int[] light) {
//        int currMax = 0, counter = 0;
//        int arr[] = new int[light.length];
//        for (int i : light) {
//            currMax = Math.max(currMax, i - 1);
//            arr[i - 1] = 1;
//            if (checkIfBlue(arr, currMax)) {
//                counter++;
//            }
//        }
//        return counter;
//    }
//
//    private boolean checkIfBlue(int[] arr, int currMax) {
//        for (int i = currMax; i >= 0; i--) {
//            if (arr[i] == 0) return false;
//        }
//        return true;
//    }


    public static void main(String[] args) {
        BulbSwitchThree bbt = new BulbSwitchThree();
        int light[] = {1, 2, 3, 4, 5, 6};
        System.out.println(bbt.numTimesAllBlue(light));
    }
}
