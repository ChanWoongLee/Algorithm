package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2667 {
	static int[][] attach;
	static boolean[][] visit;
	static int[] dx = { -1, 0, 1, 0 };// 위 오른쪽 아래 왼쪽
	static int[] dy = { 0, 1, 0, -1 };
	static int home;
	static int count;

	public static void DFS(int row, int col) {
		if (visit[row][col])
			return;
		count++;
		visit[row][col] = true;
		for (int i = 0; i < 4; i++) {
			if (row + dx[i] >= 0 && row + dx[i] < home && col + dy[i] >= 0 && col + dy[i] < home
					&& attach[row + dx[i]][col + dy[i]] == 1)
				DFS(row + dx[i], col + dy[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		home = Integer.parseInt(bf.readLine());
		attach = new int[home][home];
		visit = new boolean[home][home];
		for (int i = 0; i < home; i++) {
			String[] line = bf.readLine().split("");
			for (int j = 0; j < home; j++) {
				attach[i][j] = Integer.parseInt(line[j]);
			}
		}
		int resultCount = 0;
		ArrayList<Integer> result = new ArrayList();
		for (int i = 0; i < home; i++) {
			for (int j = 0; j < home; j++) {
				if (!visit[i][j] && attach[i][j] == 1) {
					resultCount++;
					count = 0;
					DFS(i, j);
					result.add(count);
				}
			}
		}
		result.sort((a, b) -> {
			if (a > b)
				return 1;
			if (a < b)
				return -1;
			if (a == b)
				return 0;
			else
				return 0;
		});

		System.out.println(resultCount);
		for (int r : result) {
			System.out.println(r);
		}
	}
}
