package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10 {
	static ArrayList<Integer>[] ar;
	static int[] di = { 1, 0, 0, 1, 1, 0, 1 };
	static int[] dj = { 0, 1, 0, 0, 1, 1, 1 };
	static int[] dk = { 0, 0, 1, 1, 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][][] map = new int[N][N][N];
		ArrayList<star> check = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (i == N - 1)
				st = new StringTokenizer(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < N; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int result = 0;
		boolean[][][] visit = new boolean[N][N][N];
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][k] == 0 || visit[i][j][k])
						continue;
					result++;
					Queue<star> q = new LinkedList<star>();
					q.add(new star(i, j, k));
					visit[i][j][k] = true;
					while (!q.isEmpty()) {
						star now = q.poll();
						int ks = now.k - R;
						int ke = now.k + R;
						int is = now.i - R;
						int ie = now.i + R;
						int js = now.j - R;
						int je = now.j + R;
						for (int kindex = ks; kindex <= ke; kindex++) {
							for (int iindex = is; iindex <= ie; iindex++) {
								for (int jindex = js; jindex <= je; jindex++) {
									if (0 <= kindex && kindex < N && 0 <= iindex && iindex < N && 0 <= jindex
											&& jindex < N) {
										if (visit[iindex][jindex][kindex] == false
												&& map[iindex][jindex][kindex] == 1) {
											visit[iindex][jindex][kindex] = true;
											q.add(new star(iindex, jindex, kindex));

										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}

class star {
	int i, j, k;

	public star(int i, int j, int k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
}
