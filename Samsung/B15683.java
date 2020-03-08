package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15683 {// cctv 감시 구현력을 위해 다시 풀어볼만한문제
	// 10시 30 분시작
	static int[][] map;
	static ArrayList<loc> cctv;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int result = Integer.MAX_VALUE;
	static int[][] direction = { {}, { 0 }, { 0, 2 }, { 0, 1 }, { 0, 1, 2 }, { 0, 1, 2, 3 } };

	// map을 넘기는 dfs인것
	// 브루트 포스로 모두 세야하는것 을잘인지
	// 하지만 상황에 따라 진행하는 부분에서 구현력이 부족했음
	// 위와같은 dir에 따른 횟수와 방향을 2차원 배열로 만드는게 적합!!!
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6)
					cctv.add(new loc(i, j));
			}
		}
		int[][] m = map;
		dfs(m, 0);
		System.out.println(result);
	}

	static void dfs(int[][] save, int index) {
		if (index == cctv.size()) {
			int comp = 0;
			for (int i = 0; i < save.length; i++) {
				for (int j = 0; j < save[0].length; j++) {
					if (save[i][j] == 0)
						comp++;
				}
			}
			result = result > comp ? comp : result;
			return;
		}
		loc nowl = cctv.get(index);
		int dir = map[nowl.r][nowl.c];
		index++;
		for (int j = 0; j < 4; j++) {
			if (dir == 2 && j == 2)
				continue;
			if (dir == 5 && j == 2)
				continue;
			int[][] newmap = new int[save.length][save[0].length];
			for (int k = 0; k < save.length; k++) {
				newmap[k] = Arrays.copyOf(save[k], save[0].length);
			}
			for (int i = 0; i < direction[dir].length; i++) {
				int move = 0;
				if (direction[dir][i] + j > 3)
					move = (direction[dir][i] + j) % 4;
				else
					move = (direction[dir][i] + j);

				int mr = nowl.r + dr[move];
				int mc = nowl.c + dc[move];
				while (mr >= 0 && mr < save.length && mc >= 0 && mc < save[0].length) {
					if (map[mr][mc] == 6)
						break;
					if (map[mr][mc] == 0) {
						newmap[mr][mc] = -1;
					}
					mr += dr[move];
					mc += dc[move];
				}
			}
			dfs(newmap, index);
		}
	}
}
