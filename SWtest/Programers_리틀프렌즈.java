package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 3:15 시작
public class Programers_리틀프렌즈 {

	public static void main(String[] args) {
		System.out.println(solution(5, 5, new String[] { "FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE" }));
	}

	static char[][] Map;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int M, N;

	static public String solution(int m, int n, String[] board) {
		String answer = "";
		Map = new char[m][n];
		M = m;
		N = n;
		HashMap<Character, Boolean> hm = new HashMap<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < n; j++) {
				Map[i][j] = board[i].charAt(j);
				if (Map[i][j] >= 65 && Map[i][j] <= 90)
					hm.put(Map[i][j], false);
			}
		}
		int totalBlock = hm.size();
		while (totalBlock != 0) {
			ArrayList<Character> isRemoveOk = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (Map[i][j] >= 65 && Map[i][j] <= 90 && !hm.get(Map[i][j])) {
						Character ret = bfs(i, j);
						if (ret != null && !isRemoveOk.contains(ret))
							isRemoveOk.add(ret);

					}
				}
			}
			if (isRemoveOk.size() == 0)
				return "IMPOSSIBLE";
			Collections.sort(isRemoveOk);
			Character first = isRemoveOk.get(0);
			answer += String.valueOf(first);
			isRemoveOk.clear();
			hm.put(first, true);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < n; j++) {
					if (Map[i][j] == first)
						Map[i][j] = '.';
				}
			}
			totalBlock--;
		}
		return answer;

	}

	static Character bfs(int r, int c) {
		boolean[][] visit = new boolean[M][N];
		visit[r][c] = true;
		char target = Map[r][c];
		Queue<Sacheon> q = new LinkedList<Sacheon>();
		q.add(new Sacheon(r, c, -1, -1));
		while (!q.isEmpty()) {
			Sacheon now = q.poll();
			if (Map[now.r][now.c] == target && (now.r != r || now.c != c)) {
				if (now.curve <= 1) {
					return target;
				}
			}
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR >= M || nextR < 0 || nextC >= N || nextC < 0 || visit[nextR][nextC])
					continue;
				if (Map[nextR][nextC] != target && Map[nextR][nextC] != '.')
					continue;
				if (now.dir != move && now.curve + 1 > 1)
					continue;
				if (now.dir != move) {
					q.add(new Sacheon(nextR, nextC, now.curve + 1, move));
				} else {
					q.add(new Sacheon(nextR, nextC, now.curve, move));
				}
				visit[nextR][nextC] = true;
			}
		}
		return null;
	}

	static class Sacheon {
		int r, c;
		int curve;
		int dir;

		public Sacheon(int r, int c, int curve, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.curve = curve;
			this.dir = dir;
		}

	}
}
