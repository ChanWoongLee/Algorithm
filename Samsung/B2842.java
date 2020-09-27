package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2842 {
	// 7 : 24
	static int N, home;
	static int[][] map;
	static String[][] height;
	static boolean[][] visit;
	static int[] dr = {-1,1,0,0,1,1}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		height = new String[N][N];
		Manduck start = null;
		int home = 0;
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < N; j++) {
				height[i][j] = str[j];
				if (str[j].equals("P"))
					start = new Manduck(i, j);
				else if (str[j].equals("."))
					home++;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[N][N];
		dfs(start.r, start.c, 0);
	}

	static void dfs(int r, int c, int res) {

	}
}

class Manduck {
	int r, c;

	public Manduck(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
