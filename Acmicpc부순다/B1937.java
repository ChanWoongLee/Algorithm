package Acmicpc�μ���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1937 {
	// ��Ž�� ������ �ð��ʰ� ���Ű�����
	// �ٵ� ����� �ȶ����� .. �׷��� �亽
	// �ᱹ�� dp �� dp[i][j] �� i,j���� �� �� �ִ� �ִ� �Ÿ�
	// �̰� Ȱ���ؼ� map[i][j] ���� 4���� Ȯ���� > map[i][j] �� �������� �ִ� +1 �ϸ��..
	// �������� ���鼭 ��ŭ �Դ����� �� �� �־��µ� ������ġ���� ����ŭ�� ������
	// dp[x][y] = dfs(nextX,nextY) + 1; �� ����
	static int N;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] visit = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = Math.max(dfs(i, j, visit), result);
			}
		}
		System.out.println(result);
	}

	static int dfs(int r, int c, int[][] visit) {
		if (visit[r][c] != 0)
			return visit[r][c];
		visit[r][c] = 1;
		for (int move = 0; move < 4; move++) {
			int nextR = r + dr[move];
			int nextC = c + dc[move];
			if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0)
				continue;
			if (map[nextR][nextC] > map[r][c]) {
				visit[r][c] = Math.max(visit[r][c], dfs(nextR, nextC, visit) + 1);
			}
		}
		return visit[r][c];
	}
}
