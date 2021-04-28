package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20544 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		if (N == 1) {
			System.out.println("0");
			return;
		}
		                  //  N번째/ 2여부/  
		int[][] dp = new int[N + 1][2]; 
		for (int i = 1; i <= N; i++) {

		}
	}

}
