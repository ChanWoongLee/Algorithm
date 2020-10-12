package SWtest;

import java.util.*;

public class Naver_B {

	public static void main(String[] args) {
		int[][] aaa = { { 0, 2 }, { 2, 1 }, { 2, 4 }, { 3, 5 }, { 5, 4 }, { 5, 7 }, { 7, 6 }, { 6, 8 } };
		int[] res = solution(9, aaa);
		System.out.println(res[0] + " " + res[1]);
	}

	static int[][] tree;
	static int[][] edge;
	static int[] result;
	static int N;
	static boolean finish = false;

	static public int[] solution(int n, int[][] edges) {
		N = n;
		tree = new int[n][n];
		edge = edges;
		for (int i = 0; i < edges.length; i++) {
			int start = edges[i][0];
			int end = edges[i][1];
			tree[start][end] = 1;
			tree[end][start] = 1;
		}
		result = new int[2];
		recur(0, 0);
		return result;
	}

	static int check(int node, boolean[] visitNode) {
		int nodeCnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		visitNode[node] = true;
		while (!q.isEmpty()) {
			node = q.poll();
			nodeCnt++;
			for (int i = 0; i < N; i++) {
				if (tree[node][i] == 0 || visitNode[i])
					continue;
				q.add(i);
				visitNode[i] = true;
			}
		}
		return nodeCnt;
	}

	static void recur(int index, int cnt) {

		if (cnt == 2) {
			boolean[] visitNode = new boolean[N];
			int treeCnt = 0;
			int treeSize = 0;
			for (int i = 0; i < N; i++) {
				if (visitNode[i])
					continue;
				treeSize = check(i, visitNode);
				if (treeSize != N / 3)
					break;
				treeCnt++;
			}
			if (treeCnt == 3)
				finish = true;
			return;
		}
		int start = 0;
		int end = 0;
		for (int i = index; i < edge.length; i++) {
			result[cnt] = i;
			start = edge[i][0];
			end = edge[i][1];
			tree[start][end] = 0;
			tree[end][start] = 0;
			recur(i + 1, cnt + 1);
			if (finish)
				return;

			tree[start][end] = 1;
			tree[end][start] = 1;
		}
	}

}
