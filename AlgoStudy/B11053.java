package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11053 {
	static int[] numAr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(bf.readLine());
		numAr = new int[size];
		dp = new int[size];
		String[] str = bf.readLine().split(" ");
		for(int i = 0; i < str.length; i++) {
			numAr[i] = Integer.parseInt(str[i]);
		}
		findLong(0);
		int max = 0;
		for(int i  =  0; i < dp.length; i++) {
			if(max < dp[i]) {
				max = dp[i]; 
			}
		}
		System.out.println(max);
	}
	static int findLong(int index) { // findLong(index)의 의미  index부터 시작한 증가 부분집합 원소개수
		if(dp[index] != 0)
			return dp[index];
		dp[index] = 1;
		for(int i = index+1; i < numAr.length; i++) {
			if(numAr[i] > numAr[index])
				dp[index] = Math.max(dp[index], findLong(i)+1);
			else
				findLong(i); // 이거 안하려면 index 시작을 -1로 !! 처음부터 다돌게
		}
		return dp[index];
	}
}
