package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14391 {
	static int N, M;
	static int[][] map;
	static boolean[] visit;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N * M];
		String[] str;
		for (int i = 0; i < N; i++) {
			str = bf.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		dfs(0);
		System.out.println(ans);

	}

	static void dfs(int index) {
		if (index == N * M) {
			int idx = 0;
			boolean[][] cal = new boolean[N][M];
			StringBuffer stb;
			int r = 0, c = 0, sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cal[i][j])
						continue;
					stb = new StringBuffer();
					r = i;
					c = j;
					if (visit[i * N + j]) {
						while (true) {
							stb.append(map[r][c]);
							cal[r][c] = true;
							c += 1;
							if (c + 1 > M)
								break;
							if (visit[r * M + c] == false)
								break;
						}
					} else {
						while (true) {
							stb.append(map[r][c]);
							cal[r][c] = true;
							r += 1;
							if (r + 1 > N)
								break;
							if (visit[r * M + c] == true)
								break;
						}
					}
					sum += Integer.parseInt(stb.toString());
				}
			}
			ans = Math.max(sum, ans);

			return;
		}
		visit[index] = false;
		dfs(index + 1);
		visit[index] = true;
		dfs(index + 1);

	}
}
