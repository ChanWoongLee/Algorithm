package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17822_re {
	static int[][] pan;
	static int[][] move;
	static int[] ma = { 1, 0, -1, 0 };// 위 오른쪽 아래 왼쪽
	static int[] mb = { 0, 1, 0, -1 };
	static boolean change = false;
	static boolean changed = false;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		pan = new int[N + 1][M];
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move = new int[T][3];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
