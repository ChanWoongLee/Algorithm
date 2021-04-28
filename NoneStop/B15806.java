package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15806 {
	static int N, M, K, T;
	static int dr[] = { 1, 1, 2, 2, -1, -1, -2, -2 };
	static int dc[] = { -2, 2, -1, 1, -2, 2, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		Queue<Virus> virus = new LinkedList<>();
		Queue<Virus> check = new LinkedList<>();
		map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken()) - 1;
			virus.add(new Virus(R, C, 0));
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int R = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken()) - 1;
			check.add(new Virus(R, C, 0));
		}
		int time = 0;
		while (!virus.isEmpty()) {
			int vSize = virus.size();
			time++;
			for (int i = 0; i < vSize; i++) {
				Virus now = virus.poll();
				if (now.t + 1 != map[now.r][now.c])
					map[now.r][now.c] = 0;
				for (int move = 0; move < 8; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
						continue;
					if (map[nextR][nextC] == now.t + 1)
						continue;
					map[nextR][nextC] = now.t + 1;
					virus.add(new Virus(nextR, nextC, now.t + 1));
				}
			}
			if (time == T)
				break;
		}
		for (Virus checkPos : check) {
			if (map[checkPos.r][checkPos.c] != 0) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	static class Virus {
		int r, c, t;

		public Virus(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

	}
}
