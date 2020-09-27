package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2 : 8 �� ����
public class B16929 {
	static int N, M;
	static String[][] map;
	static int[] temp;
	static int[] dr = { 0, 0, 1, 0, -1 };// ������ �Ʒ� ���� ��
	static int[] dc = { 0, 1, 0, -1, 0 };
	static int[] reverse = { 0, 3, 4, 1, 2 };
	static boolean answer = false;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		if (N > M)
			max = N;
		else
			max = M;
		map = new String[N][M];
		temp = new int[2];
		for (int i = 0; i < N; i++) {
			str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = str[j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int[][] visit = new int[N][M];
				dfs(i, j, i, j, map[i][j], visit);
//				for (int ii = 0; ii < N; ii++) {
//					for (int jj = 0; jj < M; jj++) {
//						System.out.print(visit[ii][jj] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
				if (answer) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}

	static void dfs(int r, int c, int startR, int startC, String target, int[][] visit) {
		if (answer)
			return;
		for (int move = 1; move <= 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
				continue;
			if (nextR == startR && nextC == startC && visit[startR][startC] != reverse[move]) {
				answer = true;
				return;
			}
			if (visit[nextR][nextC] != 0)
				continue;
			if (!map[nextR][nextC].equals(target))
				continue;
			visit[r][c] = move;
			dfs(nextR, nextC, startR, startC, target, visit);
		}
	}
}
