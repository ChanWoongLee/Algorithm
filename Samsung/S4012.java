package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4012 {
	// 8 : 35 Ω√¿€
	static int N;
	static int[][] source;
	static boolean[] cook;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			source = new int[N][N];
			cook = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					source[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			recur(0, 0);
			System.out.println("#" + t + " " + result);
		}
	}

	static int solve() {
		int A = 0;
		int B = 0;
		for (int i = 0; i < N; i++) {
			if (cook[i]) {
				for (int j = i + 1; j < N; j++) {
					if (cook[j]) {
						A += (source[i][j] + source[j][i]);
					}
				}
			} else {
				for (int j = i + 1; j < N; j++) {
					if (!cook[j]) {
						B += (source[i][j] + source[j][i]);
					}
				}
			}
		}
		return Math.abs(A - B);
	}

	static void recur(int index, int cnt) {
		if (cnt == N / 2) {
			int res = solve();
			result = res < result ? res : result;
			return;
		}

		for (int i = index; i < N; i++) {
			cook[i] = true;
			recur(i + 1, cnt + 1);
			cook[i] = false;
		}
	}
}
