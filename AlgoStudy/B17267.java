package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17267 {
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] realvisit;
	static int[] dr = { -1, 1, 0, 0 };// 위 아래 오른쪽 왼쪽
	static int[] dc = { 0, 0, 1, -1 };
	static int mapR;
	static int mapC;

	// 1:25 시작
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		mapR = map.length;
		mapC = map[0].length;
		st = new StringTokenizer(bf.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visit = new boolean[map.length][map[0].length];
		realvisit = new boolean[mapR][mapC];
		int nowX = 0, nowY = 0;
		for (int i = 0; i < map.length; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 2) {
					nowX = i;
					nowY = j;
				}
			}
		}
		visit[nowX][nowY] = true;
		realvisit[nowX][nowY] = true;
		dfs(nowX, nowY, L, R);
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (realvisit[i][j] == true)
					count++;
			}
		}
		System.out.println(count);
	}

	static void dfs(int x, int y, int L, int R) {
		int movex = x;
		int movey = y;
		while (true) {
			movex = movex + dr[0];
			movey = movey + dc[0];
			if (movex < 0 || movex >= map.length || movey < 0 || movey >= map[0].length || map[movex][movey] == 1)
				break;
			realvisit[movex][movey] = true;
			dfs(movex, movey, L, R);
		}
		movex = x;
		movey = y;
		while (true) {
			movex = movex + dr[1];
			movey = movey + dc[1];
			if (movex < 0 || movex >= map.length || movey < 0 || movey >= map[0].length || map[movex][movey] == 1)
				break;
			realvisit[movex][movey] = true;
			dfs(movex, movey, L, R);
		}
		// for (int i = 0; i < 2; i++) {
		// int mx = x + dr[i];
		// int my = y + dc[i];
		// if (mx < 0 || mx >= map.length || my < 0 || my >= map[0].length ||
		// map[mx][my] == 1)
		// continue;
		// visit[mx][my] = true;
		// realvisit[mx][my] = true;
		// dfs(mx, my, L, R);
		// visit[mx][my] = false;
		// }
		for (int i = 2; i < 4; i++) {
			int mx = x + dr[i];
			int my = y + dc[i];
			if (mx < 0 || mx >= map.length || my < 0 || my >= map[0].length || map[mx][my] == 1)
				continue;
			if (visit[mx][my] == true)
				continue;
			if (i == 2 && R != 0) {
				visit[mx][my] = true;
				realvisit[mx][my] = true;
				dfs(mx, my, L, R - 1);
				visit[mx][my] = false;
			} else if (i == 3 && L != 0) {
				visit[mx][my] = true;
				realvisit[mx][my] = true;
				dfs(mx, my, L - 1, R);
				visit[mx][my] = false;
			}

		}
	}
}
