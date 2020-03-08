package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.sampled.ReverbType;

public class B17472 {
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ArrayList<dis> d = new ArrayList();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}
		visit = new boolean[N][M];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					Queue<loc> q = new LinkedList();
					q.add(new loc(i, j));
					map[i][j] = cnt;
					while (!q.isEmpty()) {
						loc nowl = q.poll();
						visit[nowl.r][nowl.c] = true;
						for (int k = 0; k < 4; k++) {
							if (nowl.r + dr[k] >= 0 && nowl.r + dr[k] < N && nowl.c + dc[k] >= 0 && nowl.c + dc[k] < M
									&& !visit[nowl.r + dr[k]][nowl.c + dc[k]]
									&& map[nowl.r + dr[k]][nowl.c + dc[k]] != 0) {
								q.add(new loc(nowl.r + dr[k], nowl.c + dc[k]));
								visit[nowl.r + dr[k]][nowl.c + dc[k]] = true;
								map[nowl.r + dr[k]][nowl.c + dc[k]] = cnt;
							}
						}
					}
					cnt++;
				}
			}
		}
		int[][] breidge = new int[cnt][cnt];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (map[i][j] != 0 && map[i][j + 1] == 0 && map[i][j + 2] == 0) {
					int start = map[i][j];
					int b = 2;
					for (int k = j + 3; k < M; k++) {
						if (map[i][k] == 0)
							b++;
						else {
							j = k;
							breidge[start][map[i][k]] = b;
							d.add(new dis(start, map[i][k], b));
							k = M;
						}
					}
				}
			}
		}
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N - 2; i++) {
				if (map[i][j] != 0 && map[i + 1][j] == 0 && map[i + 2][j] == 0) {
					int start = map[i][j];
					int b = 2;
					for (int k = i + 3; k < N; k++) {
						if (map[k][j] == 0)
							b++;
						else {
							i = k;
							breidge[start][map[k][j]] = breidge[start][map[k][j]] < b ? breidge[start][map[k][j]] : b;
							d.add(new dis(start, map[k][j], b));
							k = N;
						}
					}
				}
			}
		}
		Collections.sort(d);
		boolean[] resvisit = new boolean[cnt];
		int result = 0;
		// for(dis v : d) {
		// boolean finish = true;
		// for(int i = 1; i < cnt; i ++) {
		// if(resvisit[i] == false)
		// finish = false;
		// }
		// if(finish)
		// break;
		//
		// resvisit[v.r] = true;
		// resvisit[v.c] = true;
		// result += v.v;
		 //System.out.println(v.r+ " "+ v.c+ " "+v.v);
		// }
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				System.out.print(breidge[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}

class dis implements Comparable<dis> {
	int r, c, v;

	dis(int rr, int cc, int vv) {
		r = rr;
		c = cc;
		v = vv;
	}

	@Override
	public int compareTo(dis arg0) {
		return this.v - arg0.v;
	}
}

class loc {
	int r, c;

	loc(int x, int y) {
		r = x;
		c = y;
	}
}
