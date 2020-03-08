package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10164 {
	static int[][] map;
	static int needR = 0, needC = 0;
	static int first = 0;
	static int second = 0;
	static int[] dr = { 0, 1 };// 오른쪽 , 아래
	static int[] dc = { 1, 0 };// 오른쪽 , 아래

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cnt++;
				if (cnt == num) {
					map[i][j] = 1;
					needR = i;
					needC = j;
					break;
				}
			}
		}
		dfs(0, 0);
		dfs2(needR, needC);
		System.out.println(first*second);
	}

	static void dfs(int r, int c) {
		if (r == needR && c == needC) {
			first++;
			return;
		}
		if (r + 1 <= needR)
			dfs(r + 1, c);
		if (c + 1 <= needC)
			dfs(r, c + 1);
	}

	static void dfs2(int r, int c) {
		if (r == map.length - 1 && c == map[0].length - 1) {
			second++;
			return;
		}
		if (r + 1 < map.length)
			dfs2(r + 1, c);
		if (c + 1 < map[0].length)
			dfs2(r, c + 1);
	}
}
