package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18809_re_re {
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
		dfs(0,0);
		System.out.println(result);
	}

//	static void dfs(int index, int cnt) {
//		if (cnt == R + G) {
//			for(gardenloc a : temp)
//			System.out.print(a.r+","+a.c+" ");
//		System.out.println();
//			dfs2(0, 0);
//			return;
//		}
//		if (index == possible.size())
//			return;
//		temp[cnt] = possible.get(index);
//		dfs(index + 1, cnt + 1);
//		dfs(index + 1, cnt);
//	}
	static void dfs(int index, int cnt) {
		if (cnt == R + G) {
			dfs2(0, 0);
			return;
		}
	
		for (int i = index; i < possible.size(); i++) {
			temp[cnt] = possible.get(i);
			dfs(i + 1, cnt + 1);
		}
	}

	static void dfs2(int index, int cnt) {
		if (cnt == R) {
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
		// 현재 temp에는 배양액을 뿌릴 자리가 결정되있음
		// 현재 temp2에는 빨간 배양액 뿌릴 자리가 결정되어있음
		int[][] mapClone = new int[N][M];
		int[][][] visit = new int[2][N][M];// 0 은 빨강 1은 파랑
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[0][i], -1);
			Arrays.fill(visit[1][i], -1);
		}
		for (int i = 0; i < N; i++)
			mapClone[i] = Arrays.copyOf(map[i], M);
		Queue<water> q = new LinkedList();
		for (int i = 0; i < temp.length; i++) {
			if (temp2[i]) {
				q.add(new water(temp[i].r, temp[i].c, 3, 0));
				visit[0][temp[i].r][temp[i].c] = 0;
			} else {
				q.add(new water(temp[i].r, temp[i].c, 4, 0));
				visit[1][temp[i].r][temp[i].c] = 0;
			}
		}
		int res = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				water now = q.poll();
				if (visit[now.color == 3 ? 0 : 1][now.r][now.c] == -2)
					continue;
				for (int move = 0; move < 4; move++) {
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextR < 0 || nextR >= N || nextC >= M || nextC < 0)// 범위 확인
						continue;
					if (mapClone[nextR][nextC] == 0) // 호수확인
						continue;
					if ((now.color == 3 && visit[1][nextR][nextC] == now.cnt + 1)
							|| (now.color == 4 && visit[0][nextR][nextC] == now.cnt + 1)) {
						res++;
						visit[1][nextR][nextC] = -2;
						visit[0][nextR][nextC] = -2;
						continue;
					} // 간자리가 상대의 cnt일때 꽃피우고 continue

					if (visit[0][nextR][nextC] != -1 || visit[1][nextR][nextC] != -1) // 이미 다녀간 자리일때
						continue;

					q.add(new water(nextR, nextC, now.color, now.cnt + 1));
					visit[now.color == 3 ? 0 : 1][nextR][nextC] = now.cnt + 1;
				}
			}
		}
		result = res > result ? res : result;
	}
}

class gardenloc {
	int r, c;

	public gardenloc(int r, int c) {
		this.r = r;
		this.c = c;
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