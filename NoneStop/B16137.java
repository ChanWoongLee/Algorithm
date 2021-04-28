package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16137 {
	static int N, M;
	static int[][] map;
	static boolean visit[][][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[2][N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Human> q = new LinkedList<>();
		q.add(new Human(0, 0, 0, false));
		visit[0][N - 1][N - 1] = true;
		int time = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Human now = q.poll();
				if (now.r == N - 1 && now.c == N - 1) {
					System.out.println(time);
					return;
				}
				for (int move = 0; move < 4; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
						continue;
					if (visit[now.bridge == true ? 1 : 0][nextR][nextC])
						continue;

					if (map[now.r][now.c] == 0) { // 현재 위치가 이동중이였다면 다음이 땅일때만 움직이기
						if (map[nextR][nextC] == 1) {
							q.add(new Human(nextR, nextC, now.time + 1, now.bridge));
							visit[now.bridge == true ? 1 : 0][nextR][nextC] = true;
						} else
							continue;
					} else { // 현재 위치가 이동중이 아닐때
						if (map[nextR][nextC] == 0) {// 아무것도 없을떼
							if (now.bridge) { // 이미 다리를 쓴경우 파기
								continue;
							} else if (time == 0 || M % time == 0) {// 다리 놓을 수 있음
								q.add(new Human(nextR, nextC, now.time + 1, true));
								visit[1][nextR][nextC] = true;
							} else { // 다리가 있는데 못놓을때 대기
								q.add(new Human(now.r, now.c, now.time + 1, now.bridge));
							}
						} else if (map[nextR][nextC] != 1) { // 다리가 있을때
							if (map[nextR][nextC] % time == 0) {// 아다리가 맞은경우
								q.add(new Human(nextR, nextC, now.time + 1, now.bridge));
								visit[now.bridge == true ? 1 : 0][nextR][nextC] = true;
							} else {// 아다리 안맞으면 대기
								q.add(new Human(now.r, now.c, now.time + 1, now.bridge));
							}
						} else {// 그냥 평지 일때
							q.add(new Human(nextR, nextC, now.time + 1, now.bridge));
							visit[now.bridge == true ? 1 : 0][nextR][nextC] = true;
						}

					}
				}
			}
			time++;
		}

	}

	static boolean checkGo(int r, int c, int time) {
		if (map[r][c] == 1)
			return true;
		else if (time % map[r][c] == 0)
			return true;
		else
			return false;
	}

	static class Human {
		int r, c;
		int time;
		boolean bridge;

		public Human(int r, int c, int time, boolean bridge) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.bridge = bridge;
		}

	}
}
