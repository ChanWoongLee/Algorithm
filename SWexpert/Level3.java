package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Level3 {
	static int[] temp;
	static boolean[] visit;
	static int count = 0;
	static int N;
	static long K;
	static int[] result;
	static boolean finish = false;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());
		N = n;
		K = k;
		result = new int[N];
		temp = new int[N];
		visit = new boolean[N + 1];
		backtracking(0);
		
	}

	static void backtracking(int cnt) {
		if (finish)
			return;
		if (cnt == N) {
			for (int t : temp) {
				System.out.print(t+" ");
			}
			System.out.println();
			count++;
			if (count == K) {
				for (int i = 0; i < N; i++) {
					result[i] = temp[i];
				}
				finish = true;
			}
			return;
		}
		for (int i = 1; i < 4; i++) {
			if (visit[i] == true)
				continue;
			temp[cnt] = i;
			visit[i] = true;
			backtracking(cnt + 1);
			visit[i] = false;
		}

	}
}
