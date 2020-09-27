package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1590 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] home = new int[M];
		for (int i = 0; i < M; i++) {
			home[i] = Integer.parseInt(bf.readLine());
		}
		int[] gomu = new int[M];
		int total = 0;
		for (int i = 0; i < M - 1; i++) {
			gomu[i] = home[i + 1] - home[i];
			total += gomu[i];
		}
		gomu[M - 1] = N - total;
		Arrays.sort(gomu);
	}

}
