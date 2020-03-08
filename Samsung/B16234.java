package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B16234 {
	// 10 : 22 Ω√¿€
	static int[][] map;
	static int[][] map2;
	static int[][] mapteam;
	static boolean[][] visit;
	static ArrayList<loc> save;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R, L;
	static int score = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		map2 = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean finish = false;
		int result = 0;
		while (!finish) {
			int team = 1;
			visit = new boolean[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					save = new ArrayList();
					score = map[i][j];
					if (!visit[i][j]) {
						visit[i][j] = true;
						dfs(i, j, team);
						team++;
					}
					if (save.isEmpty() && map2[i][j] == 0) {
						team--;
						map2[i][j] = score;
					} else if (map2[i][j] == 0) {
						score /= (save.size()+1);
						map2[i][j] = score;
						for (int k = 0; k < save.size(); k++) {
							map2[save.get(k).r][save.get(k).c] = score;
						}
					}
				
				}
			}
			map = map2;
			map2 = new int[size][size];
			if (team == 1)
				finish = true;
			else
				result++;
		}
		System.out.println(result);
	}

	static void dfs(int r, int c, int team) {
		for (int i = 0; i < 4; i++) {
			int mr = r + dr[i];
			int mc = c + dc[i];
			if (mr >= 0 && mr < map.length && mc >= 0 && mc < map.length && !visit[mr][mc]) {
				if (Math.abs(map[r][c] - map[mr][mc]) >= L && Math.abs(map[r][c] - map[mr][mc]) <= R) {
					save.add(new loc(mr, mc));
					visit[mr][mc] = true;
					score += map[mr][mc];
					dfs(mr, mc, team);
				}
			}
		}
	}

}
