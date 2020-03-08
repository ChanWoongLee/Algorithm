package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {
	static int N;
	static int K;
	static int[][] dp;// dp[i][j] i번째 보석까지 탐색한 현상태 , j만큼의 무게를 가져갔을때 획득한 가치의 최대가치
	// 이렇게 정하면 자연스럽게 그다음과 그전, 점화식, 부분구조 로 표현할 수 가 있다 !!! 이단계가 가장 중요한듯!!
	// 일단 완전 탐색까지 생각은 잘했지만 메모이제이션을 어떤 의미로 설계할지 생각못함!!
	// 어떻게? 이렇게 근데 두가지로 나뉨-> i번째 보석 가져간 경우 dp[i][j] = dp[i-1][j - w[i]] + v[i];
	// -> i번쨰 보석 가져가지 않은경우 dp[i][j] = dp[i-1][j];
	static int[] weigth;
	static int[] value;

	public static void main(String[] args) throws IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		weigth = new int[N+1];
		value = new int[N+1];
		for(int i = 1; i<= N; i++) {
			st = new StringTokenizer(bf.readLine());
			weigth[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i ++) {
			for(int j =0; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - weigth[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weigth[i]]+value[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
