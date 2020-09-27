package Samsung2020_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17836 {
	static int N, M, T;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] noWeapon = new boolean[N][M];
		boolean[][] yesWeapon = new boolean[N][M];
		Queue<User> q = new LinkedList<User>();
		q.add(new User(0, 0, false, 0));
		noWeapon[0][0] = true;
		while (!q.isEmpty()) {
			User now = q.poll();
			if (now.time > T) {
				System.out.println("Fail");
				return;
			}
			if (now.r == N - 1 && now.c == M - 1) {
				System.out.println(now.time);
				return;
			}
			int nextR = 0;
			int nextC = 0;
			if (now.weapon) {
				for (int move = 0; move < 4; move++) {
					nextR = now.r + dr[move];
					nextC = now.c + dc[move];
					if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0 || yesWeapon[nextR][nextC])
						continue;
					q.add(new User(nextR, nextC, true, now.time + 1));
					yesWeapon[nextR][nextC] = true;
				}
			} else {
				for (int move = 0; move < 4; move++) {
					nextR = now.r + dr[move];
					nextC = now.c + dc[move];
					if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0 || noWeapon[nextR][nextC])
						continue;
					if (map[nextR][nextC] == 1)
						continue;

					if (map[nextR][nextC] != 2) {
						q.add(new User(nextR, nextC, false, now.time + 1));
						noWeapon[nextR][nextC] = true;
					} else {
						if (!yesWeapon[nextR][nextC]) {
							q.add(new User(nextR, nextC, true, now.time + 1));
							yesWeapon[nextR][nextC] = true;
						}
					}
				}
			}
		}
		System.out.println("Fail");
	}

	static class User {
		int r, c;
		boolean weapon;
		int time;

		public User(int r, int c, boolean weapon, int time) {
			super();
			this.r = r;
			this.c = c;
			this.weapon = weapon;
			this.time = time;
		}

	}
}
