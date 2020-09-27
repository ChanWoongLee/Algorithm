package Inha.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DP_행렬곱셈순서출력 {

	static int[][] dp; // dp[i][j]의 의미 : i 번째 행렬부터 j 번째 행렬까지의 최소곱!!!
	static int[][] dp2;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (i == 0) {
				ar.add(a);
				ar.add(b);
			} else {
				ar.add(b);
			}
		}
		dp = new int[n + 1][n + 1]; // dp[i][j]의 의미 : i 번째 행렬부터 j 번째 행렬까지의 최소곱!!!
		dp2 = new int[n + 1][n + 1];
		// 11 22 33 ... / 12 23 34 45 56 67/ 13 24 ... / 1n 이 답!
		for (int differ = 1; differ <= n; differ++) {
			for (int i = 1; i + differ < n + 1; i++) {
				int j = differ + i;
				int save = Integer.MAX_VALUE;
				int saveIndex = i;
				for (int k = i; k <= j - 1; k++) {
					if (dp[i][k] + dp[k + 1][j] + ar.get(i - 1) * ar.get(k) * ar.get(j) < save) {
						save = dp[i][k] + dp[k + 1][j] + ar.get(i - 1) * ar.get(k) * ar.get(j);
						saveIndex = k;
					}
				}
				dp2[i][j] = saveIndex;
				dp[i][j] = save;
			}
		}
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1;j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}System.out.println();
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1;j++) {
				System.out.print(dp2[i][j]+" ");
			}System.out.println();
		}System.out.println();
		order(1,n);
	}

	static void order(int i, int j) {
		if(i == j)
			System.out.print("A"+dp2[i][j]);
		else {
			int k = dp2[i][j];
			System.out.print("(");
			order(i,k);
			order(k+1,j);
			System.out.print(")");
		}
	}
}
