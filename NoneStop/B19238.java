package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B19238 {
	static int N, M, FUEL;
	static int[][] map;
	static Pos[] user;
	static Pos[] dest;
	static int[][] userMap;
	static int[][] destMap;
	static int startR, startC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		FUEL = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		startR = Integer.parseInt(st.nextToken()) - 1;
		startC = Integer.parseInt(st.nextToken()) - 1;
		user = new Pos[M + 1];
		userMap = new int[N][N];
		dest = new Pos[M + 1];
		destMap = new int[N][N];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(bf.readLine());
			int userR = Integer.parseInt(st.nextToken()) - 1;
			int userC = Integer.parseInt(st.nextToken()) - 1;
			int destR = Integer.parseInt(st.nextToken()) - 1;
			int destC = Integer.parseInt(st.nextToken()) - 1;
			user[i] = new Pos(userR, userC);
			userMap[userR][userC] = i;
			dest[i] = new Pos(destR, destC);
			destMap[destR][destC] = i;
		}
		for (int i = 0; i < M; i++) {
			int nowUser = findUser();
			if (nowUser == -1) {
				System.out.println("-1");
				return;
			}
			int state = goDest(nowUser);
			if (state == -1) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(FUEL);
	}

	static int goDest(int u) {
		int nowR = user[u].r;
		int nowC = user[u].c;
		int destR = dest[u].r;
		int destC = dest[u].c;
		Taxi now = new Taxi(nowR, nowC, FUEL);
		Queue<Taxi> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		int pay = 0;
		q.add(now);
		visit[now.r][now.c] = true;
		while (!q.isEmpty()) {
			int qSize = q.size();

			for (int i = 0; i < qSize; i++) {
				Taxi taxi = q.poll();
				if (destMap[taxi.r][taxi.c] == u) {
					destMap[taxi.r][taxi.c] = 0;
					FUEL = taxi.fuel + pay * 2;
					startR = taxi.r;
					startC = taxi.c;
					return 1;
				}

				if (taxi.fuel == -1)
					continue;
				for (int move = 0; move < 4; move++) {
					int nextR = taxi.r + dr[move];
					int nextC = taxi.c + dc[move];
					if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0)
						continue;
					if (visit[nextR][nextC] || map[nextR][nextC] == 1)
						continue;
					visit[nextR][nextC] = true;
					q.add(new Taxi(nextR, nextC, taxi.fuel - 1));
				}
			}
			pay++;
		}
		return -1;
	}

	static int findUser() {
		Taxi now = new Taxi(startR, startC, FUEL);
		if (userMap[now.r][now.c] != 0) {
			int u = userMap[now.r][now.c];
			userMap[now.r][now.c] = 0;
			return u;
		}
		Queue<Taxi> q = new LinkedList<>();
		PriorityQueue<Taxi> pq;
		q.add(now);
		boolean[][] visit = new boolean[N][N];
		visit[now.r][now.c] = true;
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Taxi taxi = q.poll();
				if (taxi.fuel == 0)
					return -1;
				for (int move = 0; move < 4; move++) {
					int nextR = taxi.r + dr[move];
					int nextC = taxi.c + dc[move];
					if (nextR >= N || nextC >= N || nextR < 0 || nextC < 0)
						continue;
					if (visit[nextR][nextC] || map[nextR][nextC] == 1)
						continue;
					visit[nextR][nextC] = true;
					q.add(new Taxi(nextR, nextC, taxi.fuel - 1));
				}
			}
			pq = new PriorityQueue<>();
			for (Taxi taxi : q) {
				pq.add(taxi);
			}
			for (Taxi taxi : pq) {
				if (userMap[taxi.r][taxi.c] != 0) {
					int u = userMap[taxi.r][taxi.c];
					userMap[taxi.r][taxi.c] = 0;
					FUEL = taxi.fuel;
					return u;
				}
			}
		}
		return -1;
	}

	static class Taxi implements Comparable<Taxi> {
		int r, c, fuel;

		public Taxi(int r, int c, int fuel) {
			super();
			this.r = r;
			this.c = c;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(Taxi o) {
			if (this.r < o.r)
				return -1;
			else if (this.r > o.r)
				return 1;
			else {
				if (this.c < o.c)
					return -1;
				else if (this.c > o.c)
					return 1;
				else
					return 0;
			}
		}

	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}
