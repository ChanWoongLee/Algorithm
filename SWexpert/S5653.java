package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import AlgoStudy.codeForce1;

public class S5653 {
	static virus[][] map;
	static ArrayList<virus> v = new ArrayList();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			int result = 0;
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());// N
			int M = Integer.parseInt(st.nextToken());// M
			int K = Integer.parseInt(st.nextToken());// K
			virus[][] savemap = new virus[400][400];
			map = new virus[400][400];
			for (int i = 200 - (N / 2); i < 200 + (N - (N / 2)); i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 200 - (M / 2); j < 200 + (M - (M / 2)); j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num != 0) {
						map[i][j] = new virus(i, j, num, num, true);
					}
				}
			}

			while (K-- > 0) {
				for (int i = 0; i < map.length; i++) {
					savemap[i] = Arrays.copyOf(map[i], map[0].length);
				}
				for (int i = 190; i < 210; i++) {
					for (int j = 190; j < 210; j++) {
						if (map[i][j] == null)
							System.out.print("(0,0) ");
						else
							System.out.print("(" + map[i][j].time + "," + map[i][j].life + ") ");
					}
					System.out.println();
				}
				System.out.println();
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[0].length; j++) {
						if (map[i][j] != null) {
							if (map[i][j].time == -1) {
								savemap[i][j] = map[i][j];
								continue;
							}
							if (map[i][j].time != 0) {
								savemap[i][j] = new virus(i, j, map[i][j].time - 1, map[i][j].life, false);
							} else {
								for (int rotate = 0; rotate < 4; rotate++) {
									int mr = i + dr[rotate];
									int mc = j + dc[rotate];
									if (savemap[mr][mc] == null) {
										savemap[mr][mc] = new virus(mr, mc, map[i][j].life, map[i][j].life, true);
									} else if (savemap[mr][mc].first == true) {
										if (savemap[mr][mc].life < map[i][j].life)
											savemap[mr][mc] = new virus(mr, mc, map[i][j].life, map[i][j].life, true);
									}
								}
								savemap[i][j] = new virus(i, j, -1, map[i][j].life, false);
							} // Àü¿°
						}

					}
				}
				for (int i = 0; i < map.length; i++) {
					map[i] = Arrays.copyOf(savemap[i], map[0].length);
				}
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[0].length; j++) {
						if (map[i][j] != null) {
							result++;
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

}

class virus {
	int r;
	int c;
	int time;
	int life;
	boolean first;

	virus(int rr, int cc, int t, int l, boolean f) {
		r = rr;
		c = cc;
		life = l;
		time = t;
		first = f;

	}
}
