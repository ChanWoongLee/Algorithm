package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1949_GOOD {
	// 1 :20
	// dfs �� �����ƾ��� �Լ��� �׷����� Ÿ�� �������鼭 �ٽ� �ö�ö� visit�� ĭ�� ���� �ٲܼ� ������ ����
	static int N, K;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visit;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());// N
			K = Integer.parseInt(st.nextToken());// N
			map = new int[N][N];
			visit = new boolean[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max)
						max = map[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max == map[i][j]) {
						visit[i][j] = true;
						find(i, j, 1, true);
						visit[i][j] = false;
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	static void find(int r, int c, int cnt, boolean work) {
		result = result < cnt ? cnt : result;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
				continue;
			if (visit[nextR][nextC] == true)
				continue;
			if (map[r][c] <= map[nextR][nextC] && work == true) {
				int temp = map[nextR][nextC];
				if (map[nextR][nextC] - map[r][c] + 1 <= K) {
					for (int deep = map[nextR][nextC] - map[r][c] + 1; deep <= K; deep++) {
						map[nextR][nextC] -= deep;
						visit[nextR][nextC] = true;
						find(nextR, nextC, cnt + 1, false);
						map[nextR][nextC] += deep;
						visit[nextR][nextC] = false;
					}
				}
			} // ���̰� ���ų� �������� K ��ŭ �Ĺ���
			else if (map[nextR][nextC] < map[r][c]) {
				visit[nextR][nextC] = true;
				find(nextR, nextC, cnt + 1, work);
				visit[nextR][nextC] = false;
			} // ���� ������� �׳� ���ư�
		}
	}

}
