package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Summer2019_C_re {
	// 8 : 1 Ω√¿€
	static int[][] map;
	static int N, H;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] parent;

	public static void main(String[] args) {
		int[][] map = { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 }, { 10, 10, 10, 20 } };
		int[][] map2 = { { 10, 11, 10, 11 }, { 2, 21, 20, 10 }, { 1, 20, 21, 11 }, { 2, 1, 2, 1 } };
		int h = 1;
		System.out.println(solution(map, 3));
	}

	static public int solution(int[][] land, int height) {
		N = land.length;
		H = height;
		map = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		int c = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					dfs(land, i, j, c++, visit);
			}
		}
		// for (int i = 0; i < N; i++) {
		// for (int j = 0; j < N; j++) {
		// System.out.print(map[i][j] + " ");
		// }
		// System.out.println();
		// }
		// System.out.println();
		if (c == 2)
			return 0;

		parent = new int[c];
		for (int i = 0; i < c; i++)
			parent[i] = i;

		PriorityQueue<edge> pq = new PriorityQueue();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int move = 0; move < 4; move++) {
					int nextR = i + dr[move];
					int nextC = j + dc[move];
					if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0)
						continue;
					if (map[nextR][nextC] != map[i][j]) {
						pq.add(new edge(map[nextR][nextC], map[i][j], Math.abs(land[nextR][nextC] - land[i][j])));
					}
				}
			}
		}

		int answer = 0;
		int size = pq.size();
		int cnt = 1;
		for (int i = 1; i <= size; i++) {
			if (c - 1 == cnt)
				break;
			edge temp = pq.poll();
			int a = find(temp.s);
			int b = find(temp.e);
			if (a == b)
				continue;
			union(a, b);
			answer += temp.v;
			cnt++;
		}
		return answer;
	}

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot)
			parent[aRoot] = b;
		else
			return;
	}

	static void dfs(int[][] land, int r, int c, int Color, boolean[][] visit) {
		visit[r][c] = true;
		map[r][c] = Color;
		for (int move = 0; move < 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0 || visit[nextR][nextC])
				continue;
			if (Math.abs(land[r][c] - land[nextR][nextC]) > H)
				continue;

			dfs(land, nextR, nextC, Color, visit);
		}
	}

}

class edge implements Comparable<edge> {
	int s, e, v;

	public edge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}

	@Override
	public int compareTo(edge arg0) {
		if (arg0.v < this.v)
			return 1;
		else
			return -1;
	}
}