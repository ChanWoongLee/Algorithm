package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B7569 {
	static int[][] move = { { 0, 1, 0 }, // 동
			{ 0, -1, 0 }, // 서
			{ 1, 0, 0 }, // 남
			{ -1, 0, 0 }, // 북
			{ 0, 0, 1 }, // 위쪽
			{ 0, 0, -1 },// 아래쪽
	};
	static int N, H, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] NMH = bf.readLine().split(" ");
		M = Integer.parseInt(NMH[0]);
		N = Integer.parseInt(NMH[1]);
		H = Integer.parseInt(NMH[2]);
		// 3 5 1
		int[][][] tomato = new int[N][M][H];
		int level = 0;
		int next = N; int hight = 0;
		for (int i = 0; i < N * H; i++) {
			String[] input = bf.readLine().split(" ");
			if (next == i) {
				hight=0;
				level++;
				next *= 2;
			}
			for (int j = 0; j < input.length; j++) {
				tomato[hight][j][level] = Integer.parseInt(input[j]);
			}
			hight++;
		}

		int[][][] visit = new int[N][M][H];
		int result = 0;
		while (true) {
			result++;
			int[][][] tomatoduplicate = tomato.clone();
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (tomato[j][k][i] == 1) {
							visit[j][k][i] = 1;
							infection(tomato, visit, j, k, i);
						}
					}
				}
			}
			if(tomato.equals(tomatoduplicate))
				break;
			
			visit = new int[N][M][H];
			boolean stop = true;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (tomato[j][k][i] == 0) {
							stop = false;
						}
					}
				}
			}
			if(stop)
				break;
		}
		System.out.println(result);
	}

	public static void infection(int[][][] tomato, int[][][] visit, int n, int m, int h) {
		for (int i = 0; i < move.length; i++) {
			if (((0 <= n + move[i][0]) && (n + move[i][0] < N)) && ((0 <= m + move[i][1]) && (m + move[i][1] < M))
					&& ((0 <= h + move[i][2]) && (h + move[i][2] < H))) {
				if ((tomato[n + move[i][0]][m + move[i][1]][h + move[i][2]] != -1)
						&& (visit[n + move[i][0]][m + move[i][1]][h + move[i][2]] == 0)
						&& (tomato[n + move[i][0]][m + move[i][1]][h + move[i][2]] != 1)) {
					tomato[n + move[i][0]][m + move[i][1]][h + move[i][2]] = 1;
					visit[n + move[i][0]][m + move[i][1]][h + move[i][2]] = 1;
				}
			}
		}
	}

}
