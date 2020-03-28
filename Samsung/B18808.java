package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B18808 {
	static int N, M, K;
	static int[][] map;
	static ArrayList<obj> obj;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		obj = new ArrayList();
		map = new int[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int[][] temp = new int[r][c];
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < c; k++) {
					temp[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			obj.add(new obj(r, c, temp));
		}

		dfs(0);
		System.out.println(result);
	}

	static void dfs(int index) {
		if (index == K) {
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0)
						res++;
				}
			}
			result = res;
			return;
		}
		for (int rot = 0; rot < 4; rot++) {
			obj nowShape = rotate(rot, index);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (check(i, j, nowShape)) {
						dfs(index + 1);
						return;
					}
				}
			}
		}
		dfs(index + 1);
		return;

	}

	static obj rotate(int rot, int index) {
		if (rot == 0)
			return obj.get(index);
		if (rot == 2) {
			int r = obj.get(index).r;
			int c = obj.get(index).c;
			int[][] shape = obj.get(index).shape;
			int[][] temp = new int[r][c];
			int a = r - 1;
			int b = c - 1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					temp[a][b] = shape[i][j];
					b--;
				}
				b = c - 1;
				a--;
			}
			return new obj(r, c, temp);
		}
		if (rot == 1 || rot == 3) {
			int c = obj.get(index).r;// 현재 4
			int r = obj.get(index).c;// 현재 2
			int[][] shape = obj.get(index).shape;
			int[][] temp = new int[r][c];
			int a = 0;
			int b = c - 1;
			for (int i = 0; i < obj.get(index).r; i++) {
				for (int j = 0; j < obj.get(index).c; j++) {
					temp[a][b] = shape[i][j];
					a++;
				}
				b--;
				a = 0;
			}
			if (rot == 1)
				return new obj(r, c, temp);

			int[][] temp2 = new int[r][c];
			a = r - 1;
			b = c - 1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					temp2[a][b] = temp[i][j];
					b--;
				}
				b = c - 1;
				a--;
			}
			return new obj(r, c, temp2);
		}
		return null;
	}

	static boolean check(int initR, int initC, obj now) {
		int r = now.r;
		int c = now.c;
		int[][] shape = now.shape;
		if (initR + r > N || initC + c > M)
			return false;

		for (int i = initR; i < initR + r; i++) {
			for (int j = initC; j < initC + c; j++) {
				if (map[i][j] != 0 && shape[i - initR][j - initC] != 0)
					return false;
			}
		}
		for (int i = initR; i < initR + r; i++) {
			for (int j = initC; j < initC + c; j++) {
				if (shape[i - initR][j - initC] == 0 || map[i][j] != 0)
					continue;
				map[i][j] = shape[i - initR][j - initC];
			}
		}
		return true;
	}
}

class obj {
	int r, c;
	int[][] shape;

	public obj(int r, int c, int[][] shape) {
		this.r = r;
		this.c = c;
		this.shape = shape;
	}
}
