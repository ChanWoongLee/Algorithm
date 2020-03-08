package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 //어디서 틀린지 모르겠다....
public class Algospot_PI {
	static int[] num;
	static int[] dp; // index부터 시작한 최소 점수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		while (testCase-- > 0) {
			String[] str = bf.readLine().split("");
			num = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				num[i] = Integer.parseInt(str[i]);
			}
			dp = new int[str.length+1];
			Arrays.fill(dp, -1);
			System.out.println(memorize(0));
		}
	}

	static int pi(int start, int end) {
		boolean only = true;
		for(int i = start+1; i <= end; i++) {
			if(num[i] != num[start])
				only = false;
		}
		if(only)
			return 1;
		
		boolean progressive = true;
		for (int i = start; i < end; i++) {
			if (num[i + 1] - num[i] != num[start + 1] - num[start])
				progressive = false;
		}
		if (progressive && Math.abs(num[start + 1] - num[start]) == 1)
			return 2;
		if (progressive)
			return 5;
		
		boolean alternating = true; // 번갈아 나올때
		for (int i = start; i <= end; i++) {
			if(start % 2 == 0) {
				if (num[i] != num[i % 2 + start]) // 짝수는 맨처음 홀수는 다음껄로 비교
					alternating = false;
			}
			else {
				if (num[i] != num[i % 2 + start -1]) // 짝수는 맨처음 홀수는 다음껄로 비교
					alternating = false;
			}
		}
		if (alternating)
			return 4;
		
		return 10;
	}

	static int memorize(int begin) {// pi(index) 함수의 의미 index부터 시작한 최소 점수를 return 한다.
		if (begin == num.length)
			return 0;

		if (dp[begin] != -1)
			return dp[begin];
		dp[begin] = 987654321;
		for (int L = 3; L <= 5; L++) {
			if (begin + L <= num.length)
				dp[begin] = Math.min(dp[begin], memorize(begin + L) + pi(begin, begin + L - 1));
		}
		return dp[begin];
	}
}
