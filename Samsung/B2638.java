package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2638 {
	// 5 : 7 시작
	static int[][] map;
	static int N, M;
	// 동 서 남 북

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };// 동 서 남 북

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int totalNum = 0;
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					totalNum++;
			}
		}
		int res = 0;
		while (true) {
			int[][] space = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (space[i][j] != 0 || map[i][j] == 1)
						continue;
					checkSpace(i, j, space);
				}
			}
			int[][] mapClone = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						int out = 0;
						for (int move = 0; move < 4; move++) {
							int nextR = i + dr[move];
							int nextC = j + dc[move];
							if (space[nextR][nextC] == 1)
								out++;
						}
						if (out < 2) { // out이 아래면 치즈생존
							mapClone[i][j] = 1;
						} else // 2이상이면 치즈삭제
							totalNum--;
					}
				}
			}
			res++;
			if (totalNum == 0) {
				System.out.println(res);
				return;
			}
			map = mapClone;
		}

	}

	static void checkSpace(int r, int c, int[][] space) {
		Cheese start = new Cheese(r, c);
		Queue<Cheese> q = new LinkedList<Cheese>();
		Queue<Cheese> change = new LinkedList<>();
		space[r][c] = 1; // 1은 바깥으로 설정 2는 치즈안
		q.add(start);
		change.add(start);
		boolean empty = true;

		while (!q.isEmpty()) {
			Cheese now = q.poll();
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0) {// 바깥을 만나면 empty는 false로 바꿈
					empty = false;
					continue;
				}
				if (space[nextR][nextC] != 0 || map[nextR][nextC] == 1)// 왔던곳이거나 치즈가 있을때
					continue;
				q.add(new Cheese(nextR, nextC));
				change.add(new Cheese(nextR, nextC));
				space[nextR][nextC] = 1;
			}
		}
		if (empty) {
			for (Cheese cheese : change) {
				space[cheese.r][cheese.c] = 2;
			}
		}
	}
}

class Cheese {
	int r, c;

	public Cheese(int r, int c) {
		this.r = r;
		this.c = c;
	}
}