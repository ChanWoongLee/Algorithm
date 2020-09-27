package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1726 {
	// 11 : 24 Ω√¿€
	static int[][] map;
	static int N, M;
	// µø º≠ ≥≤ ∫œ

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };// µø º≠ ≥≤ ∫œ
	static int[][] rotate = { { 2, 3 }, // right , left
			{ 3, 2 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		RB start = new RB(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()) - 1, 0);
		st = new StringTokenizer(bf.readLine());
		RB end = new RB(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()) - 1, 0);

		boolean[][][] visit = new boolean[4][N][M];
		Queue<RB> q = new LinkedList<RB>();
		q.add(start);
		visit[start.dir][start.r][start.c] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			int[][] cmap = new int[N][M];
			for (int s = 0; s < size; s++) {
				RB now = q.poll();
				if (now.r == end.r && now.c == end.c && now.dir == end.dir) {
					System.out.println(now.cnt);
					return;
				}
				int nextR = now.r, nextC = now.c;
				for (int i = 1; i <= 3; i++) {
					nextR += dr[now.dir];
					nextC += dc[now.dir];
					if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
						break;
					if (map[nextR][nextC] == 1)
						break;
					if (visit[now.dir][nextR][nextC])
						continue;
					visit[now.dir][nextR][nextC] = true;
					q.add(new RB(nextR, nextC, now.dir, now.cnt + 1));
					//if(now.dir == 0)
					//	cmap[nextR][nextC] = 4;
					//else
					//	cmap[nextR][nextC] = now.dir;
					//if(nextR == 0 && nextC == M-1)
					//	System.out.println("ø°»ﬁ");
					// System.out.println(nextR + " " + nextC + " " + now.dir + " " + (now.cnt +
					// 1));
				}
				int left = rotate[now.dir][1];
				int right = rotate[now.dir][0];
				if (!visit[left][now.r][now.c]) {
					visit[left][now.r][now.c] = true;
					q.add(new RB(now.r, now.c, left, now.cnt + 1));
					///cmap[now.r][now.c] += left;
					// System.out.println(now.r + " " + now.c + " " + left + " " + (now.cnt + 1));
				}
				if (!visit[right][now.r][now.c]) {
					visit[right][now.r][now.c] = true;
					q.add(new RB(now.r, now.c, right, now.cnt + 1));
					//cmap[now.r][now.c] += right*10;
					// System.out.println(now.r + " " + now.c + " " + right + " " + (now.cnt + 1));
				}
			}
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < M; j++) {
//					System.out.print(cmap[i][j]+" ");
//				}System.out.println();
//			}System.out.println();
		}

	}

}

class RB {
	int r, c, dir, cnt;

	public RB(int r, int c, int dir, int cnt) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.cnt = cnt;
	}
}
