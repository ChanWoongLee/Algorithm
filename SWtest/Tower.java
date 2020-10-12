package SWtest;

import java.util.ArrayList;
import java.util.Arrays;

public class Tower {
	// 1 시 30분 시작
	static int N, M;
	static int[] shapeR = { -1, 0 };
	static int[] shapcC = { 0, 1 };
	static int[][][] map;

	public static void main(String[] args) {
		int[][] a = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 2, 1, 1, 1 },
				{ 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		int[][] res = solution(5, a);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1] + " " + res[i][2]);
		}

	}

	// 기둥은 보위 ,바닥위, 또다른 기둥위
	// 보는 한쪽이 기둥위, 두쪽이 연결
	static public int[][] solution(int n, int[][] build_frame) {
		n += 1;
		map = new int[2][n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(map[0][i], -1);
			Arrays.fill(map[1][i], -1);
		}
		N = build_frame.length;

		for (int i = 0; i < N; i++) {
			int r = build_frame[i][1], c = build_frame[i][0], shape = build_frame[i][2], install = build_frame[i][3];
			if (install == 0) { // 제거
				map[shape][r][c] = -1;
			} else {// 설치
				map[shape][r][c] = shape;
			}
			if (!check(n)) {
				if (install == 0) { // 제거
					map[shape][r][c] = shape;
				} else {// 설치
					map[shape][r][c] = -1;
				}
			}

		}
		ArrayList<Tow> res = new ArrayList();
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (map[0][i][j] != -1)
					res.add(new Tow(j, i, 0));
				if (map[1][i][j] != -1)
					res.add(new Tow(j, i, 1));
			}
		}
		int[][] result = new int[res.size()][3];
		for (int i = 0; i < result.length; i++) {
			Tow now = res.get(i);
			result[i][0] = now.r;
			result[i][1] = now.c;
			result[i][2] = now.s;
		}
		return result;
	}

	static boolean check(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[0][i][j] == -1)
					continue;
				else if (map[0][i][j] == 0) {
					if (i == 0)// 바닥위
						continue;
					if (map[0][i - 1][j] == 0)// 기둥위
						continue;
					if (j - 1 >= 0) {
						if (map[1][i][j - 1] == 1)
							continue;
					}
					if (map[1][i][j] == 1)// 보위
						continue;

					return false;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[1][i][j] == -1)
					continue;
				else if (map[1][i][j] == 1) {
					if (map[0][i - 1][j] == 0 || map[0][i - 1][j + 1] == 0)
						continue;
					if (j - 1 >= 0) {
						if (map[1][i][j - 1] == 1 && map[1][i][j + 1] == 1)
							continue;
					}

					return false;
				}
			}
		}
		return true;
	}
}

class Tow {
	int r, c, s;

	public Tow(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}
