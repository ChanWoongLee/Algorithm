package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2960 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] ar = new boolean[N + 1];
		Arrays.fill(ar, true);
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (ar[i]) {
				int multi = 2;
				int index = i;
				while (index <= N) {
					ar[index] = false;
					cnt++;
					if (cnt == K) {
						System.out.println(index);
						return;
					}
					index = multi * i;
					while (index <= N && !ar[index]) {
						index = multi * i;
						multi++;
					}
				}
			}

		}
	}

}
