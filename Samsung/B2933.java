package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2933 {
	// 6 : 52 시작
	static int R, C;
	static String[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		int crystalnum = 0;
		for (int i = 0; i < R; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = str[j];
				if (map[i][j].equals("x"))
					crystalnum++;
			}
		}

		st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int start = C - 1;
		int seekdir = 2;
		for (int i = 0; i < num; i++) {
			start = start == C - 1 ? 0 : C - 1; // 0 부터 시작
			seekdir = seekdir == 2 ? 3 : 2;
			int height = Integer.parseInt(st.nextToken());
			int changR = R - height;
			int changC = start;
			boolean nothingBreak = false;
			while (true) {
				if (changC >= C || changC < 0) {
					nothingBreak = true;
					break;
				}
				if (map[changR][changC].equals("x")) {
					map[changR][changC] = ".";
					crystalnum--;
					break;
				} else {
					changR += dr[seekdir];
					changC += dc[seekdir];
				}
			}
			if (nothingBreak)
				continue;

			int[][] visit = new int[R][C];
			int color = 1;
			int r = R - 1;
			int Cnumber = 0;

			for (int c = 0; c < C; c++) {
				if (visit[r][c] != 0) // 이미 bfs로 돔
					continue;
				if (map[r][c].equals(".")) // 크리스탈 없는곳
					continue;
				Cnumber += bfs(r, c, visit, color++);

			} // 바닥에 붙은 클러스터 coloring 완료
			if (Cnumber == crystalnum)
				continue;

			for (r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c].equals("x") && visit[r][c] == 0) {
						bfs(r, c, visit, color);
						r = R;
						break;
					}
				}
			}

			drop(visit, color);
		}
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				stb.append(map[i][j]);
			}
			stb.append("\n");
		}
		System.out.println(stb);
	}

	static void drop(int[][] visit, int color) {
		ArrayList<Crystal> cry = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] == color) {
					cry.add(new Crystal(i + 1, j));
					visit[i][j] = 0;
				}
			}
		}
		int down = 0;
		boolean escape = false;
		while (true) {
			for (int i = 0; i < cry.size(); i++) {
				Crystal now = cry.get(i);
				if (now.r + down >= R) {
					escape = true;
					break;
				}
				if (visit[now.r + down][now.c] != 0) {
					escape = true;
					break;
				}
			}
			if (escape) {
				down--;
				break;
			} else
				down++;
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] == 0)
					map[i][j] = ".";
				else
					map[i][j] = "x";
			}
		}
		for (int i = 0; i < cry.size(); i++) {
			Crystal now = cry.get(i);
			map[now.r + down][now.c] = "x";
		}

	}

	static int bfs(int r, int c, int[][] visit, int num) {
		Queue<Crystal> q = new LinkedList<Crystal>();
		q.add(new Crystal(r, c));
		visit[r][c] = num;
		int cnt = 0;
		while (!q.isEmpty()) {
			Crystal now = q.poll();
			cnt++;
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR >= R || nextR < 0 || nextC >= C || nextC < 0)
					continue;
				if (map[nextR][nextC].equals("."))
					continue;
				if (visit[nextR][nextC] != 0)
					continue;
				visit[nextR][nextC] = num;
				q.add(new Crystal(nextR, nextC));
			}
		}
		return cnt;
	}
}

class Crystal {
	int r, c;

	public Crystal(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
