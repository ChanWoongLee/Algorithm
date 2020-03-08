package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1929 {
	static int N;
	static int M;
	static boolean[] isPrime;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false; isPrime[1] = false;
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(isPrime[i]) {
				for(int j = i*i;  j <= N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(isPrime[i])
				System.out.println(i);
		}
	}
}
