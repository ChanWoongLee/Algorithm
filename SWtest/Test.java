package SWtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		System.out.println(solution( 4));
	}

	static boolean[][] map;
	static int result = 0;

	static public int solution(int n) {
		int answer = 0;
		map = new boolean[n][n];
		dfs(0, 0, 0, n);
		return answer;
	}

	static void dfs(int r, int c, int q, int n) {
		if (q == n) {
			result++;
			return;
		}
		for (int i = r; i < n; i++) {
			for (int j = c; j < n; j++) {
				if (check(i, j, n)) {
					map[i][j] = true;
					for(int ii = 0; ii < n ; ii++) {
						for(int jj= 0; jj < n; jj++) {
							System.out.print(map[ii][jj]+" ");
						}System.out.println();
					}System.out.println();
					dfs(i, j + 1, q + 1, n);
					map[i][j] = false;
				}
			}
		}
	}

	static int dr[] = { 1, 1, -1, -1, -1, 1, 0, 0 };
	static int dc[] = { 1, -1, -1, 1, 0, 0, -1, 1 };

	static boolean check(int r, int c, int n) {
		for (int move = 0; move < 8; move++) {
			int nextR = r;
			int nextC = c;
			while (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {
				if (map[nextR][nextC])
					return false;
				nextR += dr[move];
				nextC += dc[move];
			}

		}
		System.out.println(r + " " + c);
		return true;
	}
}
