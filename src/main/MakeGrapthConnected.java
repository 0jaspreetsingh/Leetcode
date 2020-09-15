package main;

import java.util.*;

/**
 * 1319. Number of Operations to Make Network Connected
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * @author jaspreetsingh03
 */
public class MakeGrapthConnected {

    // n computers atleast require n-1 connections to connect each other
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        int parent[] = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int components = 0;
        int extra = 0;
        for (int i = 0; i < connections.length; i++) {
            int p1 = findParent(parent, connections[i][0]);
            int p2 = findParent(parent, connections[i][1]);
            if (p1 == p2) {
                extra++;
            } else {
                parent[p1] = p2;
            }
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                components++;
            }
        }

        return components - 1 <= extra ? components - 1 : -1;
    }

    private int findParent(int parent[], int index) {
        if (index == parent[index]) {
            return index;
        }
        return findParent(parent, parent[index]);
    }

    public static void main(String[] args) {

        /**
         * 10
         * [[6,8],[0,4],[1,2],[5,8],[0,9],[1,8],[1,4],[4,9],[4,6],[3,7],[2,4],[3,5],[6,7],[4,5]]
         */

        int n = 5, connections[][] = {{0, 1}, {0, 2}, {3, 4}, {2, 3}};

        MakeGrapthConnected mgc = new MakeGrapthConnected();
        System.out.println(mgc.makeConnected(n, connections));
    }
}
