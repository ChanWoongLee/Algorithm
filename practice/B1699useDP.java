package practice;

import java.util.LinkedList;
import java.util.Scanner;

public class B1699useDP {
	static LinkedList<Integer> duble = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt(); 
		for (int i = 1; i <=1000; i++) {
			if(i*i <= k)
				duble.add(i*i);
		}
		System.out.println(duble.toString());
		int[][] dp = new int[duble.size()][k+1];
		System.out.println(topdown(dp, 0, k));

	}
	static int topdown(int[][] dp, int n, int k) {// n 제곱수부터만 사용했을때 k 가되는 최소 항의 개수
		if(n==duble.size())
			return (k==0? 0 : 10000001);
		if(dp[n][k]!=0) 
			return dp[n][k];
		
		int result = topdown(dp,n+1, k);
		if(k>=duble.get(n)) 
			result = Math.min(result,topdown(dp,n,k-duble.get(n))+1);
		dp[n][k]=result;
		System.out.println("n: "+n+" result: "+result+" k: "+k);
		return result;
	}
}
