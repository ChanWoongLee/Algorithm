package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.print.attribute.standard.MediaSize.NA;

public class Algospot_JLIS {
	static int[] numA;
	static int[] numB;
	static int[][] dp = new int[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		while (testCase-- > 0) {
			String[] str = bf.readLine().split(" ");
			int sizeA = Integer.parseInt(str[0]);
			int sizeB = Integer.parseInt(str[1]);
			numA = new int[sizeA];
			numB = new int[sizeB];

			str = bf.readLine().split(" ");
			for (int i = 0; i < sizeA; i++) {
				numA[i] = Integer.parseInt(str[i]);
			}
			str = bf.readLine().split(" ");
			for (int i = 0; i < sizeB; i++) {
				numB[i] = Integer.parseInt(str[i]);
			}
			System.out.println(findLong(-1, -1)); 
		}
	
	}

	static int findLong(int a, int b) { // findLong(a,b) 의미 a와 b 인덱스에서 시작하는 합친 증가 부분 수열의 최대 길이
		if (dp[a+1][b+1] != 0)
			return dp[a+1][b+1];
		dp[a+1][b+1] = 2;
		int aValue = (a == -1 ? Integer.MIN_VALUE : numA[a]);
		int bValue = (b == -1 ? Integer.MIN_VALUE : numB[b]);
		// a,b 의 값이 같을때  a+1,b 또는 a,b+1 의  Max
		// a,b 의 값이 다를때  dp[a][b]
		int maxElement = Math.max(aValue, bValue);
		for (int i = a+1; i < numA.length; ++i) {
			if(maxElement < numA[i])
				dp[a+1][b+1] = Math.max(dp[a+1][b+1], findLong(i, b)+1); // +1 은 자기 자신
		}
		for(int j = b+1; j < numB.length; ++j) {
			if(maxElement < numB[j])
				dp[a+1][b+1] = Math.max(dp[a+1][b+1], findLong(a, j)+1);
		}
		return dp[a+1][b+1];
	}
}
