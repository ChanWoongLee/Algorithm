package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S2105another {
	static int[][] map;
	static int result;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = -1;
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());// N
			map = new int[size][size];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					ArrayList<Integer> ar = new ArrayList();
					dfs(i, j, i, j, 0, 0, ar);
				}
			}
			System.out.println("#" + test_case + " " + result);
		}

	}

	static void dfs(int initR, int initC, int r, int c, int num, int dir, ArrayList<Integer> ar) {
		if (dir == 4) {
			if (initR == r && initC == c)
				result = result < num ? num : result;
			return;
		}
		ArrayList<Integer> save = new ArrayList();
		for (int i = 0; i < ar.size(); i++)
			save.add(ar.get(i));
		int moveR = r + dr[dir];
		int moveC = c + dc[dir];
		if (moveR < 0 || moveR >= map.length || moveC < 0 || moveC >= map.length)
			return;
		if (!save.contains(map[moveR][moveC])) {
			save.add(map[moveR][moveC]);
			dfs(initR, initC, moveR, moveC, num + 1, dir, save);
			dfs(initR, initC, moveR, moveC, num + 1, dir + 1, save);
		}
	}
}
