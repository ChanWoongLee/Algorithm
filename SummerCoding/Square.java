package SummerCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Square {
	
	public static void main(String[] args) throws IOException {
		System.out.println(solution(4));
	}

	static public int solution(int n) {
		int[] res = new int[n+1];
		int mod = 1000000007;
		res[1] = 1;
		res[2] = 2;
		for(int i = 3; i <= n; i++) {
			res[i] = ((res[i-2])%mod + (res[i-1])%mod)%mod;
		}
        return res[n]%mod;
    }
	static void dp(int n) {
		
	}
}
