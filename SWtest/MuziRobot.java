package SummerCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MuziRobot {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][][] visit = new boolean[4][101][101];
	static int N, M;
	static int[] rotate_dr = { -1, 1, 1, -1 };
	static int[] rotate_dc = { 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {
		int[][] map = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 } };
		System.out.println(solution(map));
	}

	static public int solution(int[][] board) {
		N = board.length;
		M = board[0].length;
		Rloc now = new Rloc(0, 0, 1, 0);
		Queue<Rloc> q = new LinkedList();
		q.add(now);
		visit[1][now.r][now.c] = true;
		visit[3][now.r][now.c + 1] = true;
		while (!q.isEmpty()) {
			now = q.poll(); // 무조건 기체의 왼쪽 또는 위쪽
			int otherR = now.r + dr[now.dir];
			int otherC = now.c + dc[now.dir];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (now.r == i && now.c == j)
						System.out.print(2 + " ");
					else if (otherR == i && otherC == j)
						System.out.print(2 + " ");
					else
						System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println(now.cnt);

			int oppdir = (now.dir + 2) % 4;
			if ((now.r == N - 1 && now.c == M - 1) || (otherR == N - 1 && otherC == M - 1)) {
				return now.cnt;
			}
			for (int move = 0; move < 4; move++) {
				int nextR1 = now.r + dr[move];
				int nextC1 = now.c + dc[move];
				int nextR2 = otherR + dr[move];
				int nextC2 = otherC + dc[move];
				// 범위 확인
				if (!rangeCheck(nextR1, nextC1, nextR2, nextC2))
					continue;
				// 빈칸 확인
				if (board[nextR1][nextC1] == 1 || board[nextR2][nextC2] == 1)
					continue;
				// 왔던건지 확인
				if (visit[now.dir][nextR1][nextC1] || visit[oppdir][nextR2][nextC2])
					continue;
				q.add(new Rloc(nextR1, nextC1, now.dir, now.cnt + 1));
				visit[now.dir][nextR1][nextC1] = true;
				visit[oppdir][nextR2][nextC2] = true;
			}
			// x,y 가 시계 방향
			for (int move = 0; move < 4; move += 2) {
				int ndir = 0;
				int dir = 0;
				int rdir = 0;
				int opp = 0;
				if (move == 0) {
					ndir = (now.dir + 3) % 4;
					rdir = (now.dir + 3) % 4;
				} else {
					ndir = (now.dir + 1) % 4;
					rdir = now.dir;
				}
				dir = (now.dir + 1 + move) % 4;
				opp = (dir + 2) % 4;
				int nextR = now.r + dr[ndir];
				int nextC = now.c + dc[ndir];
				int rotateR = now.r + rotate_dr[rdir];
				int rotateC = now.c + rotate_dc[rdir];
				if (!rangeCheck(nextR, nextC, rotateR, rotateC))
					continue;
				if (board[rotateR][rotateC] == 1 || board[nextR][nextC] == 1)
					continue;
				if (visit[dir][rotateR][rotateC] || visit[opp][otherR][otherC])
					continue;
				q.add(new Rloc(rotateR, rotateC, dir, now.cnt + 1));
				visit[dir][rotateR][rotateC] = true;
				visit[opp][otherR][otherC] = true;
			}
			// 반대가 실행
			for (int move = 0; move < 4; move += 2) {
				int ndir = 0;
				int dir = 0;
				int rdir = 0;
				int opp = 0;
				if (move == 0) {
					ndir = (oppdir + 3) % 4;
					rdir = (oppdir + 3) % 4;
				} else {
					ndir = (oppdir + 1) % 4;
					rdir = oppdir;
				}
				dir = (oppdir + 1 + move) % 4;
				opp = (dir + 2) % 4;
				int nextR = otherR + dr[ndir];
				int nextC = otherC + dc[ndir];
				int rotateR = otherR + rotate_dr[rdir];
				int rotateC = otherC + rotate_dc[rdir];

				if (!rangeCheck(nextR, nextC, rotateR, rotateC))
					continue;
				if (board[rotateR][rotateC] == 1 || board[nextR][nextC] == 1)
					continue;
				if (visit[dir][rotateR][rotateC] || visit[opp][now.r][now.c])
					continue;
				q.add(new Rloc(rotateR, rotateC, dir, now.cnt + 1));
				visit[dir][rotateR][rotateC] = true;
				visit[opp][now.r][now.c] = true;
			}
		}

		int answer = 0;
		return answer;
	}

	static boolean rangeCheck(int r, int c, int rr, int cc) {
		if (r >= N || r < 0 || c >= M || c < 0)
			return false;
		if (rr >= N || rr < 0 || cc >= M || cc < 0)
			return false;

		return true;

	}
}

class Rloc {
	int r, c, cnt, dir;

	public Rloc(int r, int c, int dir, int cnt) {
		this.r = r;
		this.c = c;
		this.dir = dir;
		this.cnt = cnt;
	}

}
