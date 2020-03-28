package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.TemporalAmount;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16985 {
	static int[][] pannel;
	static int[][][] cube;
	static int[][][] initCube;
	static int[] dz = { -1, 1, 0, 0, 0, 0 };// 위 , 아래, 동, 서 , 남 , 북
	static int[] dr = { 0, 0, 0, 0, 1, -1 };
	static int[] dc = { 0, 0, 1, -1, 0, 0 };
	static int result = Integer.MAX_VALUE;
	static int[] temp = new int[5];
	static int[] tempA = new int[5];
	static boolean[] visittempA = new boolean[5];

	public static void main(String[] args) throws IOException {// maaaaaze 큐브
		// 5 : 51 시작
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		cube = new int[5][5][5];
		initCube = new int[5][5][5];
		for (int z = 0; z < 5; z++) {
			for (int r = 0; r < 5; r++) {
				st = new StringTokenizer(bf.readLine());
				for (int c = 0; c < 5; c++) {
					initCube[z][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}
		trackingA(0, 0);
		if (result == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(result);

	}

	static void trackingA(int index, int cnt) {
		if (cnt == 5) {

			for (int i = 0; i < 5; i++) {
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						cube[tempA[i]][r][c] = initCube[i][r][c];
					}
				}
			}
			trackingB(0);
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (visittempA[i] == false) {
				visittempA[i] = true;
				tempA[cnt] = i;
				trackingA(i, cnt + 1);
				visittempA[i] = false;
			}
		}
	}

	static void trackingB(int cnt) {
		if (cnt == 5) {
			solve();
			return;
		}
		for (int i = 0; i < 4; i++) {
			temp[cnt] = i;
			trackingB(cnt + 1);
		}
	}

	static void solve() {
		for (int i = 0; i < 5; i++) {
			for (int r = 0; r < temp[i]; r++) {
				rotate(i);
			}
		}
		if (cube[0][0][0] == 0 || cube[4][4][4] == 0)
			return;
		cubeloc init = new cubeloc(0, 0, 0);
		Queue<cubeloc> q = new LinkedList();
		boolean[][][] visit = new boolean[5][5][5];
		q.add(init);
		visit[0][0][0] = true;
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			res++;
			if (result < res)
				return;
			for (int i = 0; i < size; i++) {
				cubeloc now = q.poll();
				for (int move = 0; move < 6; move++) {
					int nextZ = now.z + dz[move];
					int nextR = now.r + dr[move];
					int nextC = now.c + dc[move];
					if (nextZ == 4 && nextR == 4 && nextC == 4) {
						result = res;
						return;
					}
					if (nextZ < 0 || nextZ >= 5 || nextR < 0 || nextR >= 5 || nextC < 0 || nextC >= 5)
						continue;
					if (visit[nextZ][nextR][nextC])
						continue;
					if (cube[nextZ][nextR][nextC] == 0)
						continue;
					visit[nextZ][nextR][nextC] = true;
					q.add(new cubeloc(nextZ, nextR, nextC));
				}
			}
		}
	}

	static void rotate(int z) {
		int temp[][] = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = cube[z][i][j];
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cube[z][i][j] = temp[4 - j][i];
			}
		}
	}
}

class cubeloc {
	int z, r, c;

	public cubeloc(int z, int r, int c) {
		this.z = z;
		this.r = r;
		this.c = c;
	}
}
