package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12100_re {
	// 2시 55분시작
	static int N;
	static int result = 0;
	static int[][] map;
	static int[] dr = { -1, 0, 0, 1 };// 위 왼쪽 오른쪽 아래
	static int[] dc = { 0, -1, 1, 0 };
	static int[] reverse = { 3, 2, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > result)
					result = map[i][j];
			}
		}
		int max = result;
		dfs(map, max, 0);
		System.out.println(result);
	}

	static void dfs(int[][] m, int max, int cnt) {
		if (cnt == 5)
			return;

		for (int move = 0; move < 4; move++) {
			int[][] temp = new int[N][N];
			for (int i = 0; i < N; i++)
				temp[i] = Arrays.copyOf(m[i], N);

			int[] ret = new int[2];
			ret = solve(temp, move, max);

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(temp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(move + " " + cnt);
//			System.out.println();

			result = result < ret[1] ? ret[1] : result;
			if (ret[0] == 0)
				continue;
			dfs(temp, ret[1], cnt + 1);
		}
	}

	static int[] solve(int[][] map, int dir, int max) {
		int change = 0;
		int[] ret = new int[2];
		boolean[][] cal = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int r = dir <= 1 ? i : N - 1 - i;
				int c = dir <= 1 ? j : N - 1 - j;// 대박 두줄이다  
				if (map[r][c] == 0)
					continue;
				while (true) {
					int nextR = r + dr[dir];
					int nextC = c + dc[dir];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
						break;
					if (map[nextR][nextC] == map[r][c] && !cal[nextR][nextC]) {
						map[nextR][nextC] += map[r][c];
						map[r][c] = 0;
						change = 1;
						cal[nextR][nextC] = true;
						if (max < map[nextR][nextC])
							max = map[nextR][nextC];
						break;
					} // 합쳐질때 합치고 움직임종료
					else if (map[nextR][nextC] == 0) {
						map[nextR][nextC] = map[r][c];
						map[r][c] = 0;
						r += dr[dir];
						c += dc[dir];
						change = 1;
					} // 없는 칸일때 담칸에 자기넣고 움직임
					else {
						break;
					} // 다른거 잇을때
				}
			}
		}
		ret[0] = change;
		ret[1] = max;
		return ret;
	}
}
