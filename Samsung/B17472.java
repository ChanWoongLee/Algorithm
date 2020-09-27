package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.sampled.ReverbType;

public class B17472 {
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] father;

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
		cnt--;
		int[][] node = new int[cnt + 1][cnt + 1];
		father = new int[cnt + 1];
		for (int i = 1; i < cnt + 1; i++)
			father[i] = i;
		for (int i = 0; i < cnt + 1; i++) {
			Arrays.fill(node[i], 20);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;
				for (int move = 0; move < 4; move++) {
					int r = i;
					int c = j;
					int count = -1;
					while (true) {
						r += dr[move];
						c += dc[move];

						count++;

						if (r < 0 || r >= N || c < 0 || c >= M)
							break;
						if (map[r][c] == map[i][j])
							break;
						if (map[r][c] != 0) {
							if (count <= 1)
								break;
							else {
								if (node[map[i][j]][map[r][c]] > count) {
									node[map[i][j]][map[r][c]] = count;
									node[map[r][c]][map[i][j]] = count;
									break;
								}
							}
							break;
						}
					}
				}
			}
		}
		PriorityQueue<dis> pq = new PriorityQueue();

		for (int i = 0; i < cnt + 1; i++) {
			for (int j = 0; j <= i; j++) {
				if (node[i][j] != 20) {
					pq.add(new dis(i, j, node[i][j]));
				}
			}
		}
		int result = 0;
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			dis now = pq.poll();
			if (father_find(now.start) != father_find(now.end)) {
				union(now.start, now.end);
				result += node[now.start][now.end];
			}
		}
		int grandfatger = father_find(1);
		for (int i = 2; i < cnt + 1; i++) {
			if (father_find(i) != grandfatger) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(result);

	}

	static void union(int a, int b) {
		int afather = father_find(a);
		int bfather = father_find(b);
		if (afather != bfather) {
			father[afather] = bfather;
		}
	}

	static int father_find(int a) {
		if (a == father[a])
			return a;
		else
			return father_find(father[a]);

	}

}

class dis implements Comparable<dis> {
	int start, end, weight;

	dis(int rr, int cc, int vv) {
		start = rr;
		end = cc;
		weight = vv;
	}

	@Override
	public int compareTo(dis arg0) {
		return this.weight - arg0.weight;
	}
}

class loc {
	int r, c;

	loc(int x, int y) {
		r = x;
		c = y;
	}
}
