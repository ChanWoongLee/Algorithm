package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

public class S5644 {
	// 12 : 25 Ω√¿€
	static ArrayList<Elec>[][] map;
	static int[][] bc;
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());// N
			int A = Integer.parseInt(st.nextToken());// N
			map = new ArrayList[10][10];
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					map[i][j] = new ArrayList<>();
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
			for (int i = 1; i <= A; i++) {
				st = new StringTokenizer(bf.readLine());
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int num = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				Queue<Eloc> q = new LinkedList();
				q.add(new Eloc(r, c));
				boolean[][] visit = new boolean[10][10];
				map[r][c].add(new Elec(i, p));
				visit[r][c] = true;
				int cnt = 0;
				while (!q.isEmpty()) {
					int size = q.size();
					for (int s = 0; s < size; s++) {
						Eloc nowloc = q.poll();
						for (int move = 1; move < 5; move++) {
							int nextR = nowloc.r + dr[move];
							int nextC = nowloc.c + dc[move];
							if (nextR < 0 || nextR >= 10 || nextC < 0 || nextC >= 10)
								continue;
							if (visit[nextR][nextC] == true)
								continue;
							q.add(new Eloc(nextR, nextC));
							visit[nextR][nextC] = true;
							map[nextR][nextC].add(new Elec(i, p));
						}
					}
					cnt++;
					if (cnt == num)
						break;
				}
			}
			for (int i = 0; i < 10; i++)
				for (int j = 0; j < 10; j++)
					Collections.sort(map[i][j], Collections.reverseOrder());
			int r1 = 0;
			int c1 = 0;
			int r2 = 9;
			int c2 = 9;
			int result = 0;
			for (int i = 0; i <= M; i++) {
				int nowA_p = 0;
				int nowA_n = -1;
				if (!map[r1][c1].isEmpty()) {
					nowA_p = map[r1][c1].get(0).power;
					nowA_n = map[r1][c1].get(0).num;
				}
				int nowB_p = 0;
				int nowB_n = -1;
				if (!map[r2][c2].isEmpty()) {
					nowB_p = map[r2][c2].get(0).power;
					nowB_n = map[r2][c2].get(0).num;
				}
				if (nowA_n != -1 && nowB_n != -1 && nowA_n == nowB_n) {
					if (map[r1][c1].size() == 1 && map[r2][c2].size() == 1) {
						result += (nowA_p / 2);
					} else {
						int plus = 0;
						if (map[r1][c1].size() > 1) {
							plus = plus < (map[r1][c1].get(1).power + nowB_p) ? (map[r1][c1].get(1).power + nowB_p)
									: plus;
						}
						if (map[r2][c2].size() > 1) {
							plus = plus < (map[r2][c2].get(1).power + nowA_p) ? (map[r2][c2].get(1).power + nowA_p)
									: plus;
						}
						result += plus;
						System.out.println(plus);
					}

				} else {
					result += (nowA_p + nowB_p);
				}
				r1 += dr[user1[i]];
				c1 += dc[user1[i]];
				r2 += dr[user2[i]];
				c2 += dc[user2[i]];
			}

			System.out.println("#" + test_case + " " + result);
		}

	}
}

class Eloc {
	int r, c;

	public Eloc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Elec implements Comparable<Elec> {
	int num, power;

	public Elec(int num, int power) {
		this.num = num;
		this.power = power;
	}

	@Override
	public int compareTo(Elec o) {
		return Integer.compare(this.power, o.power);
	}
}