package Acmicpc부순다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1937 {
	// 완탐은 무조건 시간초가 날거같았음
	// 근데 방법이 안떠오름 .. 그래서 답봄
	// 결국은 dp 임 dp[i][j] 는 i,j에서 갈 수 있는 최대 거리
	// 이걸 활용해서 map[i][j] 에서 4방향 확인후 > map[i][j] 인 곳에서의 최대 +1 하면됨..
	// 몰랐던점 가면서 얼만큼 왔는지는 할 수 있었는데 현재위치에서 간만큼을 계산못함
	// dp[x][y] = dfs(nextX,nextY) + 1; 로 하자
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
