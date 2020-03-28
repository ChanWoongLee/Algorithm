package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18809 {
	static int N, M, G, R;
	static int[][] map;
	static int result = 0;
	static ArrayList<gardenloc> possible = new ArrayList();
	static gardenloc[] temp;
	static boolean[] temp2;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		temp = new gardenloc[R + G];
		temp2 = new boolean[R + G];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = bf.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 2)
					possible.add(new gardenloc(i, j));
			}
		}
		dfs(0, 0);
		System.out.println(result);
	}

	static void dfs(int index, int cnt) {
		if (cnt == R + G) {
			// 현재 temp에는 배양액을 뿌릴 자리가 결정되있음
			// for (int i = 0; i < temp.length; i++)
			// System.out.print(temp[i].r + "," + temp[i].c + " ");
			// System.out.println();
			dfs2(0, 0);
			return;
		}
		if (index == possible.size())
			return;
		temp[cnt] = possible.get(index);
		dfs(index + 1, cnt + 1);
		dfs(index + 1, cnt);
	}

	static void dfs2(int index, int cnt) {
		if (cnt == R) {
			// for(int i = 0 ; i < temp2.length; i++)
			// System.out.print(temp2[i]+" ");
			// System.out.println();
			solve();
			return;
		}
		if (index == temp.length)
			return;
		temp2[index] = true;
		dfs2(index + 1, cnt + 1);
		temp2[index] = false;
		dfs2(index + 1, cnt);
	}

	static void solve() {
		cnt++;
		boolean see = false;
		// 현재 temp에는 배양액을 뿌릴 자리가 결정되있음
		// 현재 temp2에는 빨간 배양액 뿌릴 자리가 결정되어있음
		int[][] mapClone = new int[N][M];
		for (int i = 0; i < N; i++)
			mapClone[i] = Arrays.copyOf(map[i], M);
		Queue<water> q = new LinkedList();
		water[][] activate = new water[N][M];
		for (int i = 0; i < temp.length; i++) {
			if (temp2[i]) {
				q.add(new water(temp[i].r, temp[i].c, 3, 0));
				mapClone[temp[i].r][temp[i].c] = 3;
				activate[temp[i].r][temp[i].c] = new water(temp[i].r, temp[i].c, 3, 0);
			} else {
				q.add(new water(temp[i].r, temp[i].c, 4, 0));
				mapClone[temp[i].r][temp[i].c] = 4;
				activate[temp[i].r][temp[i].c] = new water(temp[i].r, temp[i].c, 4, 0);
			}
		}
		int res = 0;

		while (!q.isEmpty()) {
			water now = q.poll();
			if (mapClone[now.r][now.c] == 7)
				continue;
			for (int move = 0; move < 4; move++) {
				int nextR = now.r + dr[move];
				int nextC = now.c + dc[move];
				if (nextR < 0 || nextR >= N || nextC >= M || nextC < 0)
					continue;
				if (mapClone[nextR][nextC] == 0 || mapClone[nextR][nextC] == 7)
					continue;
				if (activate[nextR][nextC] != null && now.cnt+1 == activate[nextR][nextC].cnt) {
					if (now.color != activate[nextR][nextC].color) {
						mapClone[nextR][nextC] = 7;
						activate[nextR][nextC] = null;
						res++;
						continue;
					}
				}
				if (mapClone[nextR][nextC] == 3 || mapClone[nextR][nextC] == 4)
					continue;
				q.add(new water(nextR, nextC, now.color, now.cnt + 1));
				mapClone[nextR][nextC] = now.color;
				activate[nextR][nextC] = new water(nextR, nextC, now.color, now.cnt+1);
			}
		}
		result = res > result ? res : result;
	}
}

class water {
	int r, c, color, cnt;

	public water(int r, int c, int color, int cnt) {
		this.r = r;
		this.c = c;
		this.color = color;
		this.cnt = cnt;
	}
}

class gardenloc {
	int r, c;

	public gardenloc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
