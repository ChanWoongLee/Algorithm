package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10942 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		String[] str = bf.readLine().split(" ");
		int[] num = new int[N];
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(str[i]);
		st = new StringTokenizer(bf.readLine());
		int test = Integer.parseInt(st.nextToken());
		boolean[][] dp = new boolean[N][N];
		for (int gap = 0; gap < N; gap++) {
			for (int start = 0; start + gap < N; start++) {
				if (start == start + gap)
					dp[start][start] = true;
				else if (gap == 1 && (num[start] == num[start + 1]))
					dp[start][start + 1] = true;
				else {
					if ((num[start] == num[start + gap]) && dp[start + 1][start + gap - 1])
						dp[start][start + gap] = true;
				}
			}
		}
		for (int i = 0; i < test; i++) {
			st = new StringTokenizer(bf.readLine());
			int S = Integer.parseInt(st.nextToken()) - 1;
			int E = Integer.parseInt(st.nextToken()) - 1;
			if (dp[S][E]) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		System.out.println(sb);
	}

}
