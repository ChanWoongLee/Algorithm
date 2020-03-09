package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5650 { // 핀볼
	// 9 시 46 분
	static int[][] map;
	static int N;
	static int[] dr = { -1, 0, 1, 0 };// 위 오른쪽 아래 왼쪽
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] block = { {}, { 2, 3, 1, 0 }, { 1, 3, 0, 2 }, { 3, 2, 0, 1 }, { 2, 0, 3, 1 }, { 2, 3, 0, 1 } };
	static boll[] blackholl1 = new boll[11];
	static boll[] blackholl2 = new boll[11];
	static int result;

	// block[블럭][현재방향] = 바뀌는 방향
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());// N
			map = new int[N][N];
			blackholl2 = new boll[11];
			blackholl1 = new boll[11];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6) {
						if (blackholl1[map[i][j]] == null)
							blackholl1[map[i][j]] = new boll(i, j);
						else
							blackholl2[map[i][j]] = new boll(i, j);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					game(i, j);
				}
			}
			System.out.println("#" + test_case + " " + result);
		}

	}

	static void game(int r, int c) {
		if (map[r][c] != 0)
			return;
		for (int index = 0; index < 4; index++) {
			int score = 0;
			int nextR = r;
			int nextC = c;
			int dir = index;
			int cnt = 0;
			while (true) {// 움직이고 확인하고 를 반복!
				nextR += dr[dir];
				nextC += dc[dir];
				// 진행
				cnt++;
				if (nextR == r && nextC == c )
					break;
				// 같은자리 게임끝
				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
					dir = block[5][dir];
					score++;
				} // 벽에 만났을때
				else if (map[nextR][nextC] >= 1 && map[nextR][nextC] <= 5) {
					dir = block[map[nextR][nextC]][dir];
					score++;
				} // 블록을 만났을때
				else if (map[nextR][nextC] >= 6 && map[nextR][nextC] <= 10) {
					int num = map[nextR][nextC];
					if (blackholl1[num].r == nextR && blackholl1[num].c == nextC) {
						nextR = blackholl2[num].r;
						nextC = blackholl2[num].c;
					} else {
						nextR = blackholl1[num].r;
						nextC = blackholl1[num].c;
					}
				} // 웜홀 만났을때
				else if (map[nextR][nextC] == -1)
					break;
				// 블랙홀 만났을때

				
			}
			result = score > result ? score : result;
		}
	}
}

class boll {
	int r, c;

	public boll(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
