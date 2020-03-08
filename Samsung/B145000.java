package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B145000 {
	// 09:36 ����
	//
	static int[] dr = { -1, 0, 1, 0 };// �� ������ �Ʒ� ����
	static int[] dc = { 0, 1, 0, -1 };
	static int[] dir = { 2, 3, 0, 1, 4 };
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int maxValue = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxValue = Math.max(map[i][j], maxValue);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, map[i][j], 1, 4, map);
				uu(i, j, map);
			}
		}
		System.out.println(result);
	}

	static void uu(int r, int c, int[][] map) {
		int sum = map[r][c];
		int min =Integer.MAX_VALUE;
		int count = 1;
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < map.length && c + dc[i] >= 0 && c + dc[i] < map[0].length) {
				min = Math.min(map[r+dr[i]][c+dc[i]], min);
				sum+=map[r+dr[i]][c+dc[i]];
				count++;
			}
		}
		if(count== 5)
			result = Math.max(result, sum-min);
		if(count == 4)
			result = Math.max(result, sum);
	}
	// map.length ���α��� , map[0].length ���α���
	// dir�� ���� ������ -1 ������ 0 1 2 3 ���ʷ� �� ������ �Ʒ� ����

	static void dfs(int r, int c, int sum, int count, int direction, int[][] map) {
		if (count == 4) {
			result = Math.max(result, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < map.length && c + dc[i] >= 0 && c + dc[i] < map[0].length)
				if (direction == dir[i])
					continue;
				else
					dfs(r + dr[i], c + dc[i], sum + map[r + dr[i]][c + dc[i]], count + 1, i, map);
		}
	}
}
