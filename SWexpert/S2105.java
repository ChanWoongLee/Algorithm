package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S2105 {
	static int[][] map;
	static LinkedList<Integer> list;
	static boolean[] value;
	static int result;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { -1, 1, 1, -1 };

	// 1 2
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = -1;
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());// N
			map = new int[size][size];
			value = new boolean[size];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			list = new LinkedList();
			sunyel(0);
			System.out.println("#" + test_case + " " + result);
		}
	}

	static void sunyel(int cnt) {
		if (cnt == 2) {
			int total = 0;
			for (int v : list) {
				total += v;
			}
			if (total > map.length - 1)
				return;
			for (int i = 0; i < map.length - 2; i++) {
				for (int j = 1; j < map.length - 1; j++) {
					if (find(i, j)) {
						if (total * 2 < result)
							return;
						result = total * 2;
						return;
					}
				}
			}

			return;
		}
		for (int i = map.length - 2; i >= 1; i--) {
			list.addFirst(i);
			sunyel(cnt + 1);
			list.removeFirst();
		}
	}

	static boolean find(int r, int c) {
		ArrayList<Integer> ar = new ArrayList();
		for (int v : list)
			ar.add(v);
		int row = ar.get(0);
		int col = ar.get(1);
		ar.clear();
		for (int i = 0; i < row; i++) {
			if (ar.contains(map[r][c])) {
				return false;
			}
			ar.add(map[r][c]);
			r += dr[0];
			c += dc[0];
			if (r < 0 || r >= map.length || c < 0 || c >= map.length) {
				return false;
			}
		}
		for (int i = 0; i < col; i++) {
			if (ar.contains(map[r][c])) {
				return false;
			}
			ar.add(map[r][c]);
			r += dr[1];
			c += dc[1];
			if (r < 0 || r >= map.length || c < 0 || c >= map.length) {
				return false;
			}
		}
		for (int i = 0; i < row; i++) {
			if (ar.contains(map[r][c])) {
				return false;
			}
			ar.add(map[r][c]);
			r += dr[2];
			c += dc[2];
			if (r < 0 || r >= map.length || c < 0 || c >= map.length) {
				return false;
			}
		}
		for (int i = 0; i < col; i++) {
			if (ar.contains(map[r][c])) {
				return false;
			}
			ar.add(map[r][c]);
			r += dr[3];
			c += dc[3];
			if (r < 0 || r >= map.length || c < 0 || c >= map.length) {
				return false;
			}
		}
		return true;

	}
}
