package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/contain-virus/
 * 
 * @author jaspreetsingh03
 *
 */
public class ContainVirus {

	int ai[] = { 0, -1, 0, 1 };
	int aj[] = { -1, 0, 1, 0 };

	class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return i + "&" + j;
		}
	}

	public int containVirus(int[][] grid) {

		if (grid.length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		int arr[][] = new int[m][];

		for (int i = 0; i < grid.length; i++) {
			arr[i] = grid[i].clone();
		}

		List<HashSet<Node>> list = new ArrayList<HashSet<Node>>();

		List<Node> nodeList = new ArrayList<Node>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					nodeList.add(new Node(i, j));
				}
			}
		}

		for (Node node : nodeList) {
			if (arr[node.i][node.j] == 1) {
				// recursively check for neighbours
				HashSet<Node> subSet = new HashSet<ContainVirus.Node>();
				fillPath(arr, node, m, n, subSet);
				list.add(subSet);
			}
		}

		int wallsReq = 0;

		while (list.size() > 0) {
			HashSet<Node> subSet = list.get(0);
			int max = infectedNumber(grid, subSet, m, n);
			int maxIndex = 0;

			for (int i = 1; i < list.size(); i++) {
				HashSet<Node> subSet2 = list.get(i);
				int tempMax = infectedNumber(grid, subSet2, m, n);
				if (tempMax > max) {
					subSet = subSet2;
					max = tempMax;
					maxIndex = i;
				}
			}

			wallsReq += getWallsAndFillWithZero(grid, subSet, m, n);
			System.out.println(list);
			list.remove(maxIndex);
			System.out.println(list);
			for (HashSet<Node> set : list) {
				
				infect(grid, set, m, n);
			}

		}

		return wallsReq;
	}

	private int getWallsAndFillWithZero(int[][] grid, HashSet<Node> subSet, int m, int n) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j] +" ");
			}
			System.out.println();
		}
		
		int walls = 0;
		for (Node node : subSet) {
			for (int p = 0; p < 4; p++) {
				int ii = node.i + ai[p];
				int jj = node.j + aj[p];
				Node nn = new Node(ii, jj);
				System.out.println(nn);
				if (check(nn, m, n) && grid[nn.i][nn.j] == 0) {
					walls++;
				}
			}
			
			grid[node.i][node.j] = -1; // -1 denotes the safe cells
		}
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j] +" ");
			}
			System.out.println();
		}
		
		System.out.println("Walls "+walls);

		return walls;
	}

	private void infect(int[][] grid, HashSet<Node> set, int m, int n) {
		// TODO Auto-generated method stub
		HashSet<Node> temp = new HashSet<ContainVirus.Node>();
		for (Node node : set) {
			for (int p = 0; p < 4; p++) {
				int ii = node.i + ai[p];
				int jj = node.j + aj[p];
				Node nn = new Node(ii, jj);
				if (check(nn, m, n) && grid[nn.i][nn.j] == 0) {
					grid[nn.i][nn.j] = 1;
					temp.add(nn);
				}
			}
		}
		
		set.addAll(temp);

	}

	private int infectedNumber(int[][] grid, HashSet<Node> set, int m, int n) {
		// TODO Auto-generated method stub
		int arr[][] = new int[m][];

		for (int i = 0; i < grid.length; i++) {
			arr[i] = grid[i].clone();
		}
		int totalInfected = 0;
		for (Node node : set) {
			for (int p = 0; p < 4; p++) {
				int ii = node.i + ai[p];
				int jj = node.j + aj[p];
				Node nn = new Node(ii, jj);
				if (check(nn, m, n) && arr[nn.i][nn.j] == 0) {
					arr[nn.i][nn.j] = 1;
					totalInfected++;
				}
			}
		}
		return totalInfected;
	}

	public void fillPath(int arr[][], Node node, int m, int n, HashSet<Node> subSet) {
		if (check(node, m, n) && arr[node.i][node.j] == 1) {
			subSet.add(node);
			arr[node.i][node.j] = 0;
			for (int p = 0; p < 4; p++) {
				Node tempNode = new Node(node.i + ai[p], node.j + aj[p]);
				fillPath(arr, tempNode, m, n, subSet);
			}

		}

	}

	public boolean check(Node node, int m, int n) {

		return node.i >= 0 && node.i < m && node.j >= 0 && node.j < n;
	}

	public static void main(String[] args) {
		ContainVirus cv = new ContainVirus();
		int grid[][] = { { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 } };
		System.out.println(cv.containVirus(grid));
	}
}
