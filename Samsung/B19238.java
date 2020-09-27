package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 3 시 35분 시작
public class B19238 {
	static int N;
	static int M;
	static int[][] map;
	static int WALL = Integer.MAX_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] DEST;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int initFuel = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) {
					map[i][j] = WALL;
				}
			}
		}
		st = new StringTokenizer(bf.readLine());
		int initY = Integer.parseInt(st.nextToken()) - 1;
		int initX = Integer.parseInt(st.nextToken()) - 1;
		Taxi nowTaxi = new Taxi(initY, initX, initFuel);
		DEST = new int[M + 1][2];
		for (int i = 1; i <= M; i++) {
			String[] str = bf.readLine().split(" ");
			map[Integer.parseInt(str[0]) - 1][Integer.parseInt(str[1]) - 1] = i;
			DEST[i][0] = Integer.parseInt(str[2]) - 1;
			DEST[i][1] = Integer.parseInt(str[3]) - 1;
		}
		for (int i = 0; i < M; i++) {
			Taxi taxiWithUser = findUser(nowTaxi);
			if (taxiWithUser == null || taxiWithUser.fuel < 0) {
				System.out.println("-1");
				return;
			}
			nowTaxi = goDest(taxiWithUser);
			if (nowTaxi == null) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(nowTaxi.fuel);
	}

	static Taxi goDest(Taxi taxi) {
		int taxiX = taxi.x;
		int taxiY = taxi.y;
		int fuel = taxi.fuel;
		Queue<Taxi> q = new LinkedList<>();
		q.add(new Taxi(taxiY, taxiX, fuel));
		boolean[][] visit = new boolean[N][N];
		visit[taxiY][taxiX] = true;
		int destForMoney = 0;
		int destX = taxi.destX;
		int destY = taxi.destY;

		while (!q.isEmpty()) {
			int qSize = q.size();
			destForMoney++;
			for (int i = 0; i < qSize; i++) {
				Taxi now = q.poll();
				for (int move = 0; move < 4; move++) {
					int nextX = now.x + dx[move];
					int nextY = now.y + dy[move];
					if (nextX >= N || nextX < 0 || nextY >= N || nextY < 0 || visit[nextY][nextX]
							|| map[nextY][nextX] == WALL)
						continue;
					if (now.fuel <= 1)
						return null;
					if (nextX == destX && nextY == destY) {
						return new Taxi(nextY, nextX, (now.fuel - 1 + (destForMoney * 2)));
					}
					q.add(new Taxi(nextY, nextX, now.fuel - 1));
					visit[nextY][nextX] = true;
				}
			}
		}
		return null;
	}

	static Taxi findUser(Taxi taxi) {
		int taxiX = taxi.x;
		int taxiY = taxi.y;
		int fuel = taxi.fuel;
		if (map[taxiY][taxiX] > 0 && map[taxiY][taxiX] != WALL) {
			taxi.destX = DEST[map[taxiY][taxiX]][1];
			taxi.destY = DEST[map[taxiY][taxiX]][0];
			map[taxiY][taxiX] = 0;
			return taxi;
		}
		Queue<Taxi> q = new LinkedList<>();
		PriorityQueue<Taxi> pq = new PriorityQueue<>();
		q.add(new Taxi(taxiY, taxiX, fuel));
		boolean[][] visit = new boolean[N][N];
		visit[taxiY][taxiX] = true;

		while (!q.isEmpty()) {
			int qSize = q.size();
			//boolean isFindUser = false;
			for (int i = 0; i < qSize; i++) {
				Taxi now = q.poll();
				for (int move = 0; move < 4; move++) {
					int nextX = now.x + dx[move];
					int nextY = now.y + dy[move];
					if (nextX >= N || nextX < 0 || nextY >= N || nextY < 0 || visit[nextY][nextX]
							|| map[nextY][nextX] == WALL)
						continue;
					if (map[nextY][nextX] > 0) {
						pq.add(new Taxi(nextY, nextX, now.fuel-1));
					}
					//	isFindUser = true;
					if (now.fuel - 1 == 0)
						return null;
					q.add(new Taxi(nextY, nextX, now.fuel - 1));
					visit[nextY][nextX] = true;
				}
			}
//			if (!isFindUser)
//				continue;
			if(!pq.isEmpty()) {
				Taxi first = pq.poll();
				first.destX = DEST[map[first.y][first.x]][1];
				first.destY = DEST[map[first.y][first.x]][0];
				map[first.y][first.x] = 0;
				return first;
			}
			
			
			// 이게 가장 가까운거은 위에이며 왼쪽이다를 체크하는방법 priority Q 보다 좋은 듯
			// ...................................항상기억하자
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (visit[i][j] && map[i][j] > 0 && map[i][j] != WALL) { // 손님을 찾음 !!
//						for (Taxi t : q) {
//							if (t.y == i && t.x == j) {
//								t.destX = DEST[map[i][j]][1];
//								t.destY = DEST[map[i][j]][0];
//								map[i][j] = 0;
//								return t;
//							}
//						}
//					}
//				}
//			}
		}

		return null;
	}

	static class Taxi implements Comparable<Taxi>{
		int x, y, fuel;
		int destX, destY;

		public Taxi(int y, int x, int fuel) {
			this.x = x;
			this.y = y;
			this.fuel = fuel;
		}

		@Override
		public int compareTo(Taxi o) {
			if(o.y == this.y)
				return this.x - o.x;
			else
				return this.y - o.y;
		}
	}

}
