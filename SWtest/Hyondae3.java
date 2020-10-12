package SummerCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hyondae3 {
	static int[] dr = { -1, 1, 0, 0, };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int[][] m = { { 1, 1 }, { 2, 1 }, { 1, 2 }, { 3, 3 }, { 6, 4 }, { 3, 1 }, { 3, 3 }, { 3, 3 }, { 3, 4 },
				{ 2, 1 } };
		solution(m);
	}

	static public String[] solution(int[][] macaron) {
		int[][] map = new int[6][6];
		for (int i = 0; i < macaron.length; i++) {
			int sero = macaron[i][0] - 1;
			int garo = 5;
			int color = macaron[i][1];

			for (; garo >= 0; garo--) {
				if (map[garo][sero] == 0) {
					map[garo][sero] = color;
					break;
				}
			}
			for (int R = 0; R < 6; R++) {
				for (int C = 0; C < 6; C++) {
					if (map[R][C] == 0)
						continue;
					boolean[][] visit = new boolean[6][6];
					Queue<loc> q = new LinkedList();
					Queue<loc> bomb = new LinkedList();
					q.add(new loc(R, C));
					bomb.add(new loc(R, C));
					visit[R][C] = true;
					while (!q.isEmpty()) {
						loc now = q.poll();
						for (int move = 0; move < 4; move++) {
							int nextR = now.r + dr[move];
							int nextC = now.c + dc[move];
							if (nextR >= 6 || nextR < 0 || nextC >= 6 || nextC < 0)
								continue;
							if (map[nextR][nextC] != map[R][C])
								continue;
							if (visit[nextR][nextC])
								continue;

							bomb.add(new loc(nextR, nextC));
							visit[nextR][nextC] = true;
							q.add(new loc(nextR, nextC));
						}
					}
					if (bomb.size() >= 3) {
						for (loc l : bomb) {
							map[l.r][l.c] = 0;
						}
						for (int c = 0; c < 6; c++) {
							for (int r = 4; r >= 0; r--) {
								int checkR = r + 1;
								while (true) {
									if (checkR >= 6)
										break;
									if (map[checkR][c] == 0) {
										map[checkR][c] = map[checkR - 1][c];
										map[checkR - 1][c] = 0;
									}
									checkR++;
								}
							}
						}
					}

				}
			}

		}
		String[] resul = new String[6];
		for (int a = 0; a < 6; a++) {
			String res = "";
			for (int j = 0; j < 6; j++) {
				res += map[a][j];
			}
			resul[a] = res;
		}
		return resul;
	}

}

class loc {
	int r, c;

	public loc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
