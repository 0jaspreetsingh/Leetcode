package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * 
 * @author jaspreetsingh03
 *
 */
public class MakeGrapthConnected {

	// n computers atleast require n-1 connections to connect each other
	public int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1) {
			return -1;
		}

		List<HashSet<Integer>> li = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			HashSet<Integer> temp = new HashSet<Integer>();
			temp.add(i);
			li.add(i, temp);
		}

		for (int i = 0; i < connections.length; i++) {

			int p = connections[i][0];
			int q = connections[i][1];

			join(li, p, q);

		}
		
		System.out.println(li);

		return 0;
	}



	private void join(List<HashSet<Integer>> li, int p, int q) {

		HashSet<Integer> temp1 = li.get(p);
		HashSet<Integer> temp2 = li.get(q);

		temp1.addAll(temp2);
		temp2.addAll(temp1);
	}

	public static void main(String[] args) {

		int n = 4, connections[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 } };

		MakeGrapthConnected mgc = new MakeGrapthConnected();
		System.out.println(mgc.makeConnected(n, connections));
	}
}
