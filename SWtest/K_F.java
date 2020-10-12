package SummerCoding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class K_F {

	public static void main(String[] args) {
		System.out.println(
				solution(new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 1, 0));
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] BOARD;

	static public int solution(int[][] board, int r, int c) {
		BOARD = board;
		int max = 0;
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != 0)
					hs.add(board[i][j]);
			}
		}
		max = hs.size();
		while (!(max == 0)) {
			int cardColor;
			Position now = null;
			if (board[r][c] != 0) {
				now = new Position(r, c);
			} else {
				now = findCard(r, c, -1);
			}
			cardColor = board[now.r][now.c];
			result++;
			int removeR = now.r;
			int removeC = now.c;
			board[removeR][removeC] = 0;
			Position findFinish = findCard(now.r, now.c, cardColor);
			result++;
			r = findFinish.r;
			c = findFinish.c;
			board[r][c] = 0;
			max--;
		}
		return result;
	}

	static int result = 0;

	public static Position findCard(int r, int c, int card) {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(r, c));
		boolean[][] visit = new boolean[4][4];
		visit[r][c] = true;
		while (!q.isEmpty()) {
			int qSize = q.size();
			result++;
			for (int i = 0; i < qSize; i++) {
				Position now = q.poll();
				for (int move = 0; move < 4; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR >= 4 || nextR < 0 || nextC >= 4 || nextC < 0 || visit[nextR][nextC])
						continue;
					if (card == -1) {
						if (BOARD[nextR][nextC] != 0) {
							return new Position(nextR, nextC);
						}
					} else {
						if (BOARD[nextR][nextC] == card) {
							return new Position(nextR, nextC);
						}
					}
					q.add(new Position(nextR, nextC));
					visit[nextR][nextC] = true;
				}
				for (int move = 0; move < 4; move++) {
					int nextR = now.r;
					int nextC = now.c;
					while (true) {
						nextR += dr[move];
						nextC += dc[move];

						if (nextR >= 4 || nextR < 0 || nextC >= 4 || nextC < 0) {
							nextR -= dr[move];
							nextC -= dc[move];
							break;
						}
						if (BOARD[nextR][nextC] != 0)
							break;
					}
					if (card == -1) {
						if (BOARD[nextR][nextC] != 0) {
							return new Position(nextR, nextC);
						}
					} else {
						if (BOARD[nextR][nextC] == card) {
							return new Position(nextR, nextC);
						}
					}
					if (visit[nextR][nextC])
						continue;
					q.add(new Position(nextR, nextC));
					visit[nextR][nextC] = true;
				}
			}

		}
		return null;
	}

	static class Position {
		int r, c;

		public Position(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}
}
