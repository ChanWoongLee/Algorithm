package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

public class S5644 {
	// 12 : 25 시작
	static ArrayList<elec>[][] map;
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());// N
			int A = Integer.parseInt(st.nextToken());// N
			map = new ArrayList[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i][j] = new ArrayList();
				}
			}
			int[] user1 = new int[M + 1];
			int[] user2 = new int[M + 1];
			user1[0] = 0;
			user2[0] = 0;
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i < M + 1; i++)
				user1[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i < M + 1; i++)
				user2[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(bf.readLine());
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int num = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				Queue<eloc> q = new LinkedList();
				q.add(new eloc(r, c));
				map[r][c].add(new elec(i, p));
				boolean[][] visit = new boolean[10][10];
				visit[r][c] = true;
				int cnt = 0;
				while (!q.isEmpty()) {
					int size = q.size();
					for (int s = 0; s < size; s++) {
						eloc nowloc = q.poll();
						for (int move = 1; move < 5; move++) {
							int nextR = nowloc.r + dr[move];
							int nextC = nowloc.c + dc[move];
							if (nextR < 0 || nextR >= 10 || nextC < 0 || nextC >= 10)
								continue;
							if (visit[nextR][nextC] == true)
								continue;
							q.add(new eloc(nextR, nextC));
							visit[nextR][nextC] = true;
							map[nextR][nextC].add(new elec(i, p));
						}
					}
					cnt++;
					if (cnt == num)
						break;
				}
			}
			int r1 = 0;
			int c1 = 0;
			int r2 = 9;
			int c2 = 9;
			for (int i = 0; i <= M; i++) {
				int a, b;
				int init = result;
				Collections.sort(map[r1][c1], Collections.reverseOrder());
				Collections.sort(map[r2][c2], Collections.reverseOrder());
				if (map[r1][c1].size() == 0 && map[r2][c2].size() == 0) {
					r1 += dr[user1[i]];
					c1 += dc[user1[i]];
					r2 += dr[user2[i]];
					c2 += dc[user2[i]];
					continue;
				} else if (map[r1][c1].size() == 0 || map[r2][c2].size() == 0) {
					if (map[r1][c1].size() == 0)
						result += map[r2][c2].get(0).power;
					else
						result += map[r1][c1].get(0).power;
				} // 둘중에 하나만 0 일경우
				else if (map[r1][c1].size() != 0 && map[r2][c2].size() != 0) {
					if (map[r1][c1].get(0).order == map[r2][c2].get(0).order) {
						int temp = 0;
						if (map[r1][c1].size() >= 2) {
							int compare = 0;
							compare += map[r1][c1].get(1).power;
							compare += map[r2][c2].get(0).power;
							temp = temp < compare ? compare : temp;
						}
						if (map[r2][c2].size() >= 2) {
							int compare = 0;
							compare += map[r2][c2].get(1).power;
							compare += map[r1][c1].get(0).power;
							temp = temp < compare ? compare : temp;
						}
						int compare = 0;
						compare += map[r1][c1].get(0).power / 2;
						compare += map[r2][c2].get(0).power / 2;
						temp = temp < compare ? compare : temp;
						result += temp;
						
					} else {
						result += map[r1][c1].get(0).power;
						result += map[r2][c2].get(0).power;
					}
				} // 둘다0이 아닌경우 + 같은곳에 서있을때 뭐가이득인지 확인해야함
					// 둘다 0 일경우 안들어감
				r1 += dr[user1[i]];
				c1 += dc[user1[i]];
				r2 += dr[user2[i]];
				c2 += dc[user2[i]];
			}

			System.out.println("#" + test_case + " " + result);
		}

	}
}

class eloc {
	int r, c;

	public eloc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class elec implements Comparable<elec> {
	int order, power;

	public elec(int o, int p) {
		this.order = o;
		this.power = p;
	}

	@Override
	public int compareTo(elec arg0) {
		return this.power - arg0.power;
	}
}
