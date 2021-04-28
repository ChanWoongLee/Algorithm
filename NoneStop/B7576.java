package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int normal = 0;
		Queue<Pos> q = new LinkedList<Pos>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					normal++;
				else if (map[i][j] == 1) {
					q.add(new Pos(i, j));
				}
			}
		}
		int result = 0;
		if (normal == 0)
			System.out.println(result);
		else {
			while (!q.isEmpty()) {
				int qSize = q.size();
				for (int i = 0; i < qSize; i++) {
					Pos now = q.poll();
					int nextR, nextC;
					for (int move = 0; move < 4; move++) {
						nextR = now.x + dr[move];
						nextC = now.y + dc[move];
						if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
							continue;
						if (map[nextR][nextC] == 0) {
							map[nextR][nextC] = -1;
							normal--;
							q.add(new Pos(nextR, nextC));
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
				result++;
				if (normal == 0) {
					System.out.println(result);
					return;
				}
			}
			System.out.println("-1");

		}

	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
