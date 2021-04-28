package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class B20544 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][][] dp = new int[2][3][N + 1];
		// [현재 2개가 붙어있냐 ??][현재의 상태 선인장 크기를 뜻함][몇번쨰를 뜻함]
		// 어쨋든 모든 경우는
		// 없을때 - +0 (2나온적 ㅇ), +1 (2나온적 ㅇ), +2(2나온적 ㅇ,x),
		// 1일때 - +0 (2나온적 ㅇ), +1 (2나온적 ㅇ), +2,
		// 2일때 - +0, +1
		// 고려할점 : 2가 두번나오면 안된다, 선인장은 최대 2개만 붙어있어야한다.
		// 2는 무조건 한개 있어야한다.
		dp[0][0][1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[0][0][i] = dp[1][1][i - 1] + dp[1][2][i - 1] + dp[0][0][i - 1] + dp[0][1][i - 1] + dp[0][2][i - 1];
			dp[0][2][i] = dp[0][0][i - 1];
			dp[0][1][i] = dp[0][0][i - 1];

			dp[1][2][i] = dp[0][1][i - 1];
			dp[1][1][i] = dp[0][1][i - 1] + dp[0][2][i - 1];
		}
		Optional<String> opt = new Option
	}

}
