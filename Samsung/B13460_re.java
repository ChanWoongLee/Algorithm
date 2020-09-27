package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13460_re {
	static int N, M;
	static String[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 다시풀때 1시간컷 3달전문제
	// 조금실수가 있었음

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		Queue<bead> q = new LinkedList();
		int endR = 0;
		int endC = 0;
		bead[] b = new bead[2];
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("R")) {
					b[0] = new bead(i, j, 0);
					map[i][j] = ".";
				}
				if (map[i][j].equals("B")) {
					b[1] = new bead(i, j, 0);
					map[i][j] = ".";
				}
				if (map[i][j].equals("O")) {
					endR = i;
					endC = j;
				}
			}
		}
		q.add(b[0]);
		q.add(b[1]);
		boolean[][][][] visit = new boolean[N][M][N][M];
		visit[b[0].r][b[0].c][b[1].r][b[1].c] = true;
		while (!q.isEmpty()) {
			bead nowR = q.poll();
			bead nowB = q.poll();
			if (nowR.cnt == 10) {
				System.out.println("-1");
				return;
			}
			for (int move = 0; move < 4; move++) {
				bead nextR = rolling(nowR, move);
				bead nextB = rolling(nowB, move);
				// # 이나 O 떄문에 멈춘다
				if (nextR.r == endR && nextR.c == endC) { // R 빠졋는데
					if (nextB.r == endR && nextB.c == endC)// B 도 빠졋을때
						continue;

					System.out.println(nextR.cnt);// R만 빠졌을때
					return;
				}
				if (nextB.r == endR && nextB.c == endC)
					continue; // B만 빠졌을때

				if (nextR.r == nextB.r && nextR.c == nextB.c) {
					if (nowR.c > nowB.c || nowR.r > nowB.r)
						if (move == 1 || move == 2)
							nextB = new bead(nextB.r - dr[move], nextB.c - dc[move], nextB.cnt);
						else
							nextR = new bead(nextR.r - dr[move], nextR.c - dc[move], nextR.cnt);
					if (nowR.c < nowB.c || nowR.r < nowB.r)
						if (move == 3 || move == 0)
							nextB = new bead(nextB.r - dr[move], nextB.c - dc[move], nextB.cnt);
						else
							nextR = new bead(nextR.r - dr[move], nextR.c - dc[move], nextR.cnt);
				} // 같을때 구슬 뒤로 빼주기

				if (visit[nextR.r][nextR.c][nextB.r][nextB.c])
					continue;

				visit[nextR.r][nextR.c][nextB.r][nextB.c] = true;
				q.add(nextR);
				q.add(nextB);
			}
		}
		System.out.println("-1");
	}

	static bead rolling(bead now, int dir) {
		int r = now.r;
		int c = now.c;
		while (true) {
			r += dr[dir];
			c += dc[dir];
			if (map[r][c].equals("#")) {
				r -= dr[dir];
				c -= dc[dir];
				break;
			} else if (map[r][c].equals("O"))
				break;
		}
		return new bead(r, c, now.cnt + 1);
	}
}

class bead {
	int r, c, cnt;

	public bead(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;

	}
}
