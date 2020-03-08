package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17136 {
	// 2:45 시작
	static int[][] map = new int[10][10];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] paper = new int[5];
		for (int i = 0; i < 5; i++) {
			paper[i] = 6;
		}
		dfs(0, map, paper, 0);
		if (result == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(result);
	}

	static void dfs(int index, int[][] temp, int[] paper, int cnt) {
		boolean finish = true;
		for (int i = 0; i < paper.length; i++) {
			if (paper[i] == 0)
				return;
		}
		if (cnt >= result)
			return;
		if (index == map.length * map.length) {
			result = cnt < result ? cnt : result;
			return;
		}

		for (int i = index; i < map.length * map.length; i++) {
			int nowr = i / map.length;
			int nowc = i % map.length;
			if (map[nowr][nowc] == 1) {
				for (int j = 0; j <= 4; j++) {
					// 데이터만 받은 빈집
					int[][] next = new int[map.length][map.length];
					for (int k = 0; k < map.length; k++)
						next[k] = Arrays.copyOf(temp[k], map.length);
					int[] p = new int[paper.length];
					p = Arrays.copyOf(paper, paper.length);
					//
					boolean f = fill(nowr, nowc, j, next);
					if (f) {
						p[j]--;
						dfs(i + 1, next, p, cnt++);
					}
				}

			}
		}
	}

	static boolean fill(int r, int c, int index, int[][] next) {
		boolean fill = true;
		for (int i = r; i <= r + index; i++) {
			for (int j = c; j <= c + index; j++) {
				if (i >= map.length || j >= map.length || next[i][j] != 1) {
					fill = false;
					break;
				}
			}
		}
		if (fill) {
			for (int i = r; i <= r + index; i++) {
				for (int j = c; j <= c + index; j++) {
					next[i][j] = 2;
				}
			}
			return fill;
		}
		return fill;
	}
}
