package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

import AlgoStudy.codeForce1;

// 12 5 Ω√¿€
public class B16235 {
	static int N, M, K, result;
	static int[][] nutrition;
	static int[][] map;
	static ArrayList<wood> w;
	static Deque<wood> dq = new LinkedList();
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		nutrition = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
			}
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				nutrition[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		w = new ArrayList();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			w.add(new wood(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()), true));

		}
		Collections.sort(w);
		for (wood ww : w) {
			dq.addLast(ww);
		}
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(dq.size());
	}

	static void spring() {
		for (int i = 0; i < dq.size(); i++) {
			wood nowWood = dq.removeFirst();
			int r = nowWood.r;
			int c = nowWood.c;
			int old = nowWood.old;
			if (map[r][c] - old >= 0) {
				map[r][c] -= old;
				dq.addLast(new wood(r, c, old + 1, true));
			} else {
				dq.addLast(new wood(r, c, old, false));
			}
		}
	}

	static void summer() {
		for (int i = 0; i < dq.size(); i++) {
			wood nowWood = dq.removeFirst();
			if (nowWood.alive == false) {
				map[nowWood.r][nowWood.c] += nowWood.old / 2;
				i -= 1;
			} else {
				dq.addLast(nowWood);
			}
		}
	}

	static void fall() {
		int initsize = dq.size();
		Deque<wood> save = new LinkedList();
		for (int i = 0; i < initsize; i++) {
			wood nowWood = dq.removeFirst();
			if (nowWood.old % 5 == 0) {
				dq.addLast(nowWood);
				for (int addwood = 0; addwood < 8; addwood++) {
					int nextR = nowWood.r + dr[addwood];
					int nextC = nowWood.c + dc[addwood];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
						continue;
					save.addFirst(new wood(nextR, nextC, 1, true));
				}
			}
			else {
				dq.addLast(nowWood);
			}
		}
		for (wood ww : save) {
			dq.addFirst(ww);
		}
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += nutrition[i][j];
			}
		}
	}
}

class wood implements Comparable<wood> {
	int r, c, old;
	boolean alive;

	public wood(int r, int c, int old, boolean alive) {
		this.r = r;
		this.c = c;
		this.old = old;
		this.alive = alive;
	}

	@Override
	public int compareTo(wood arg0) {
		return this.old - arg0.old;
	}
}