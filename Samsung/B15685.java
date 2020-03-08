package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import SWexpert.template;

public class B15685 {
	// 6 시10 분 시작
	static int[][] map = new int[100][100];
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int node = Integer.parseInt(st.nextToken());
		for (int i = 0; i < node; i++) {
			st = new StringTokenizer(bf.readLine());
			int c = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
			int dir = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			ArrayList<Integer> ar = new ArrayList();
			ar.add(dir);
			play(cnt, ar);
			for (int s = 0; s < ar.size(); s++) {
				r += dr[ar.get(s)];
				c += dc[ar.get(s)];
				map[r][c] = 1;
			}
		}
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (i + 1 < 100 && j + 1 < 100) {
					if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1)
						result++;
				}
			}
		}
		System.out.println(result);
	}

	static void play(int cnt, ArrayList<Integer> ar) {
		while (cnt-- > 0) {
			int temp = ar.size() - 1;
			for (int i = temp; i >= 0; i--) {
				ar.add((ar.get(i) + 1) % 4);
			}
		}

	}
}
