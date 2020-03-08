package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10835 {
	static int[] cardA;
	static int[] cardB;
	// static int[][] dp;
	static int[][] visit;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		cardA = new int[size];
		cardB = new int[size];
		visit = new int[size][size];
		for(int i = 0 ; i < visit.length; i++) {
			Arrays.fill(visit[i], -1);
		}
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < size; j++) {
				if (i == 0)
					cardA[j] = Integer.parseInt(st.nextToken());
				else
					cardB[j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0, 0));
	}

	static int dfs(int n, int m) {
		if (n == cardA.length || m == cardB.length) {
			return 0;
		}
		if (visit[n][m] != -1)
			return visit[n][m];
		if (cardA[n] > cardB[m]) {
			visit[n][m] = dfs(n, m + 1) + cardB[m];
		}
		int ret = dfs(n + 1, m + 1)>= dfs(n + 1, m) ? dfs(n+1,m+1):dfs(n+1,m);
		visit[n][m] = visit[n][m] > ret ? visit[n][m] : ret;
		return visit[n][m];
	}
}
