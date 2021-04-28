package NoneStop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P_카드짝맞추기 {

	public static void main(String[] args) {
		int out = solution(new int[][] { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } }, 1, 0);
		System.out.println(out);
	}

	static Map<Integer, ArrayList<Pos>> map;
	static boolean[] visit;
	static ArrayList<Integer> temp = new ArrayList<>();
	static int[][] board;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int realAns = Integer.MAX_VALUE;
	static int ans;
	static int[] key;

	static public int solution(int[][] board1, int r, int c) {
		map = new HashMap<Integer, ArrayList<Pos>>();
		board = board1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) {
					ArrayList<Pos> value;
					if (map.containsKey(board[i][j])) {
						value = map.get(board[i][j]);
					} else
						value = new ArrayList<>();
					value.add(new Pos(i, j));
					map.put(board[i][j], value);
				}
			}
		}
		Set<Integer> keySet = map.keySet();
		key = new int[keySet.size()];
		visit = new boolean[key.length];
		int index = 0;
		for (int k : keySet) {
			key[index++] = k;
		}
		recur(key, 0, key.length, r, c);
		return realAns;
	}

	static void recur(int[] key, int cnt, int max, int startR, int startC) {
		if (cnt == max) {
			ans = 0;
			int[][] save = new int[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					save[i][j] = board[i][j];
				}
			}
			for (int i = 0; i < temp.size(); i++) {
				Pos now = find(temp.get(i), startR, startC);
				startR = now.r;
				startC = now.c;
			}
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] = save[i][j];
				}
			}
			realAns = Math.min(ans, realAns);
			return;
		}

		for (int i = 0; i < key.length; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			temp.add(key[i]);
			recur(key, cnt + 1, max, startR, startC);
			visit[i] = false;
			temp.remove(temp.size() - 1);
		}
	}

	static Pos find(int findcard, int startR, int startC) {
		ArrayList<Pos> posInfo = map.get(findcard);
		Pos A = posInfo.get(0);
		Pos B = posInfo.get(1);
		int nowR = startR;
		int nowC = startC;
		Pos ret;
		int costA = bfs(A.r, A.c, nowR, nowC);
		int costB = bfs(B.r, B.c, nowR, nowC);
		if (costA > costB) {
			board[B.r][B.c] = 0;
			ans += costB + 1;
			nowR = B.r;
			nowC = B.c;
			ans += bfs(A.r, A.c, nowR, nowC) + 1;
			board[A.r][A.c] = 0;
			ret = new Pos(A.r, A.c);

		} else {
			board[A.r][A.c] = 0;
			ans += costA + 1;
			nowR = A.r;
			nowC = A.c;
			ans += bfs(B.r, B.c, nowR, nowC) + 1;
			board[B.r][B.c] = 0;
			ret = new Pos(B.r, B.c);
		}
		return ret;
	}

	static int bfs(int destR, int destC, int nowR, int nowC) {
		Queue<Card> q = new LinkedList<Card>();
		q.add(new Card(nowR, nowC, 0));
		boolean[][] visit = new boolean[board.length][board[0].length];
		visit[nowR][nowC] = true;
		while (!q.isEmpty()) {
			Card now = q.poll();
			if (now.r == destR && now.c == destC) {
				return now.cost;
			}

			for (int move = 0; move < 8; move++) {
				int nextR = now.r, nextC = now.c;
				if (move < 4) {
					nextR = now.r + dr[move];
					nextC = now.c + dc[move];
				} else {
					int dir = move % 4;
					while (true) {
						nextR += dr[dir];
						nextC += dc[dir];
						if (nextR >= board.length || nextR < 0 || nextC >= board[0].length || nextC < 0) {
							nextR -= dr[dir];
							nextC -= dc[dir];
							break;
						}
						if (board[nextR][nextC] != 0)
							break;

					}
				}
				if (nextR >= board.length || nextR < 0 || nextC >= board[0].length || nextC < 0)
					continue;
				if (visit[nextR][nextC])
					continue;
				visit[nextR][nextC] = true;
				q.add(new Card(nextR, nextC, now.cost + 1));
			}
		}
		return 0;
	}

	static class Card {
		int r, c, cost;

		public Card(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
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
