package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17142 {
	// 11½Ã41 ºÐ
	static int N, num;
	static int[][] map;
	static ArrayList<virus> v = new ArrayList();
	static int[] activate;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());
		activate = new int[num];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					v.add(new virus(i, j));
			}
		}
		boolean one = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					one = false;
			}
		}
		if (one) {
			System.out.println("0");
			return;
		} else
			solve(0, 0);
		if (result == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(result);
	}

	static void solve(int index, int cnt) {
		if (cnt == num) {
			int res = act();
			if (res != -1) {
				result = res < result ? res : result;
			}
			return;
		}
		if (index == v.size())
			return;
		activate[cnt] = index;
		solve(index + 1, cnt + 1);
		solve(index + 1, cnt);

	}

	static int act() {
		int[][] temp = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			temp[i] = Arrays.copyOf(map[i], N);
		}
		Queue<virus> q = new LinkedList();
		for (int i = 0; i < activate.length; i++) {
			virus now = v.get(activate[i]);
			q.add(new virus(now.r, now.c));
			visit[now.r][now.c] = true;
		}
		int time = 0;
		boolean finish = true;
		while (!q.isEmpty() && finish) {
			int end = q.size();
			finish = false;
			boolean movecheck = false;
			time++;
			for (int i = 0; i < end; i++) {
				virus vir = q.poll();
				for (int move = 0; move < 4; move++) {
					int nextR = vir.r + dr[move];
					int nextC = vir.c + dc[move];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || map[nextR][nextC] == 1)
						continue;
					if (visit[nextR][nextC])
						continue;

					q.add(new virus(nextR, nextC));
					visit[nextR][nextC] = true;
					temp[nextR][nextC] = 2;
					movecheck = true;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] == 0)
						finish = true;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] == 0)
					return -1;
			}
		}
		return time;
	}
}

class virus {
	int r, c;

	public virus(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
