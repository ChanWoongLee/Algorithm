package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865retry {
	static int[] weight;
	static int[] value;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		weight = new int[N+1];
		value = new int[N+1];
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N + 1]; // dp[index] = 처음부터index개의 배낭째 검사할때까지 가장큰 Value
		int[] dpW = new int[N + 1]; // dpW[index] = index 까지의 무게
		for (int i = 0; i < N + 1; i++) {
			dp[i] = value[i];
			dpW[i] = weight[i];
			for (int j = 0; j < i; j++) {
				if (dpW[i] + dpW[j] <= K && dp[i] + dp[j] > dp[i]) {
					dp[i] = dp[i] + dp[j];
					dpW[i] = dpW[i]+dpW[j];
				}
			}
		}
		System.out.println(dp[N]);

	}

}
