package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2133 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[N+1];
		dp[2] = 3;
		for(int i = 3 ; i <= N; i++) {
			if(i-2>=0)
				dp[i]+=dp[i-2]+3;
			if(i-4>=0)
				dp[i]+=dp[i-4]+2;
		}
		System.out.println(dp[N]);
	}

}
