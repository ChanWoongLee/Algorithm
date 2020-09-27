package Inha.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 2) {
					if (j == 0) {
						if (i + 1 >= N)
							continue;
						map[i][j] += map[i + 1][j];
					} else if (i == N - 1)
						map[i][j] += map[i][j - 1];
					else
						map[i][j] += (map[i][j - 1] < map[i + 1][j] ? map[i + 1][j] : map[i][j - 1]);
				}
			}
		}
		System.out.println(map[0][M - 1]);

	}

}
