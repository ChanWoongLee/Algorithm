package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algospot_PACKING {
	static int N;
	static String[] name;
	static int[] weight;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testcase = Integer.parseInt(st.nextToken());
		while (testcase-- > 0) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			name = new String[N + 1];
			int[] value = new int[N + 1];
			weight = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(bf.readLine());
				name[i] = st.nextToken();
				weight[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}
			int[][] dp = new int[N + 1][W + 1];
			// dp[i][j] i 까지 탐색한결과 j 무게일때의 최대 value i까지 탐색하고 j무게에서의 최댁밧
			// dp[i][j] = dp[i-1][j] , dp[i-1][j - weight[i]] + value[i] 의 max
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= W; j++) {
					dp[i][j] = dp[i - 1][j];
					if (j - weight[i] >= 0)
						dp[i][j] = dp[i][j] > dp[i - 1][j - weight[i]] + value[i] ? dp[i][j]
								: dp[i - 1][j - weight[i]] + value[i];
				}
			}
			ArrayList<String> result = recur(dp, W, 6, new ArrayList<>());
			System.out.println(dp[N][W] + " " + result.size());
			// for (String r : result) {
			// System.out.println(r);
			// }
			for (int i = result.size() - 1; i >= 0; i--)
				System.out.println(result.get(i));
		}
	}

	static ArrayList<String> recur(int[][] dp, int W, int item, ArrayList<String> arr) {
		if (item == 0)
			return arr;
		if (dp[item][W] == dp[item - 1][W])
			return recur(dp, W, item - 1, arr);
		else {
			arr.add(name[item]);
			return recur(dp, W - weight[item], item - 1, arr);
		}
	}
}
