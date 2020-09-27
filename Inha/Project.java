package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Project {
	static int N;
	static int[][] map;
	static int[][] possible;
	static int result = 0;
	static int[] dr = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		possible = new int[N][N];
		backTracking(0, 0);
		System.out.println(result);
	}

	static void backTracking(int index, int cnt) {
		if (cnt == N+1) {
			result++;
			return;
		}
		for (int i = index; i < N * N; i++) {
			if (possible[i / N][i % N] != 0)// 만약 갈수 없는 자리라면 다음자리에서 다시검사(i++)
				continue;
			// 만약 그곳에 둘수 있다면
			check(i, i);// 해당 자리에 queen두고 갈수 있는곳을 visit에 체크해준다.
			backTracking(i + 1, cnt + 1);// 다음 queen이 갈수 있는곳을 탐색한다.
			check(i, 0); // 탐색이 끝난 queen이므로 visit을 false로 바꿔준다.
		}
	}

	static void check(int index, int num) {
		int r = index / N;
		int c = index % N;
		possible[r][c] = num;
		for (int i = 0; i < 8; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			while (true) {
				if (nextR >= N || nextR < 0 || nextC < 0 || nextC >= N)
					break;
				if (num == 0 && possible[nextR][nextC] != index) {
					nextR += dr[i];
					nextC += dc[i];
					continue;
				}
				if (num != 0 && possible[nextR][nextC] != 0) {
					nextR += dr[i];
					nextC += dc[i];
					continue;
				}
				possible[nextR][nextC] = num;
				nextR += dr[i];
				nextC += dc[i];
			}
		}
	}
}
