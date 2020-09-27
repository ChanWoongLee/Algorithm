package Inha.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P13 {
	static int[][] dp;
	static int[][] p;
	static ArrayList<Integer> res = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; i++)
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		for (int i = 1; i < N + 1; i++)
			graph[i][i] = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(bf.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph[start][end] = value;
		}
		dp = new int[N + 1][N + 1];
		p = new int[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				dp[i][j] = graph[i][j];
			}
		}

		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE)
						continue;
					if (dp[i][j] > dp[i][k] + dp[k][j]) {
						p[i][j] = k;
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}
		while (true) {
			st = new StringTokenizer(bf.readLine());
			start = Integer.parseInt(st.nextToken());
			if (start == 0)
				break;
			end = Integer.parseInt(st.nextToken());
			if(dp[start][end] == Integer.MAX_VALUE) {
				System.out.println("0");
				continue;
			}
			System.out.print(dp[start][end] + " ");
			res.add(start);
			path(start, end);
			res.add(end);
			for(int i = 0; i < res.size(); i++) {
				if(i == res.size()-1)
					System.out.print(res.get(i));
				else {
					System.out.print(res.get(i)+" ");
				}
			}
			System.out.println();
			res.clear();
		}
	}

	static void path(int s, int e) {
		if (p[s][e] != 0) {
			path(s, p[s][e]);
			res.add(p[s][e]);
			path(p[s][e], e);
		}
	}
}
