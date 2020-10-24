package main;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/bulb-switcher/
 */
public class BulbSwitch {

    public int bulbSwitch(int n) {

        return (int) Math.sqrt(n);
    }


    public static void main(String[] args) {
        BulbSwitch bs = new BulbSwitch();
        System.out.println(bs.bulbSwitch(4));

    }
}
