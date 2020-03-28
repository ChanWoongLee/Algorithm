package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11559 {
	// 4 : 00 Ω√¿€
	static String[][] map = new String[12][6];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<puyo> removeList = new LinkedList();

	public static void main(String[] args) throws IOException {// ª—ø‰ª—ø‰
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < 6; j++) {
				map[i][j] = str[j];
			}
		}
		int result = 0;
		while (true) {
			if (game())
				break;
			else
				result++;
		}
		System.out.println(result);
	}

	static boolean game() {
		boolean finish = true;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j].equals("."))
					continue;
				boolean[][] visit = new boolean[12][6];
				dfs(i, j, visit);
				if (removeList.size() >= 4) {
					finish = false;
					while (!removeList.isEmpty()) {
						puyo temp = removeList.poll();
						map[temp.r][temp.c] = ".";
					}
				}
				removeList.clear();
			}
		}
		for (int i = 10; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j].equals("."))
					continue;
				if (!map[i + 1][j].equals("."))
					continue;
				int r = i;
				int c = j;
				while (true) {
					r += dr[2];
					c += dc[2];
					if (r >= 12) {
						r -= dr[2];
						c -= dc[2];
						map[r][c] = map[i][j];
						map[i][j] = ".";
						break;
					}
					if (!map[r][c].equals(".")) {
						r -= dr[2];
						c -= dc[2];
						map[r][c] = map[i][j];
						map[i][j] = ".";
						break;
					}
				}
			}
		}
		return finish;
	}

	static void dfs(int r, int c, boolean[][] visit) {
		visit[r][c] = true;
		removeList.add(new puyo(r, c));
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 0 || nextC < 0 || nextR >= 12 || nextC >= 6 || !map[r][c].equals(map[nextR][nextC]))
				continue;
			if (visit[nextR][nextC])
				continue;
			dfs(nextR, nextC, visit);
		}
	}
}

class puyo {
	int r, c;

	public puyo(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
