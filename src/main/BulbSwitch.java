package main;

import java.util.Arrays;

/**
 * unsolved , can use number of factors for a given number..
 * https://leetcode.com/problems/bulb-switcher/
 */
public class BulbSwitch {

    public int bulbSwitch(int n) {

        if (n < 2) {
            return n;
        }

        boolean arr[] = new boolean[n];
        //Arrays.fill(arr,true);

        for (int i = 1; i <= n; i++) {
            fill(arr, i);

        }

        int counter = 0;

        for (boolean val : arr
        ) {
            if (val) {
                counter++;
            }
        }


        return counter;
    }

    private void fill(boolean[] arr, int i) {
        for (int p = i - 1; p < arr.length; p += i) {
            arr[p] = !arr[p];
        }
    }

    public static void main(String[] args) {
        BulbSwitch bs = new BulbSwitch();
        System.out.println(bs.bulbSwitch(4));

    }
}
