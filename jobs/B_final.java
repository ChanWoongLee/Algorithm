package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_final {
	// 8 : 40�н���
	static int result;
	static int[][] map;
	static int N, M;
	static ArrayList<pump> p = new ArrayList<>();
	static int[] dir;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// ������ ������ array�� �����ų�� �ִ�.
	// valve  = { 
	// {1,0,0,0}
	// {1,0,1,0}
	// {1,1,1,0}
	// {1,1,1,1}
	//}
	// �׸��� �̰�  ȸ���Ѵٴ°� 1000 �� 1�� ���������� �о� 0100 �ν����� �ϸ�ȴ�.
	// ó�������� ���갡 1�϶� 3ȸ���� �ϸ� ���� ����ϴ� ������ �޶� ���
	
	
	///// �����͸� ��� �迭�� �������� �״����� �������!!!!!!!!!!!!!!!!
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= testCase; t++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			p.clear();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0 && map[i][j] != 0) {
						p.add(new pump(i, j, map[i][j]));
					}
				}
			}
			dir = new int[p.size()];
			dfs(0);
			System.out.println("#" + t + " " + result);
		}
	}

	static void spread(int[][] temp, int r, int c, int dir) {
		while (true) {
			r += dr[dir];
			c += dc[dir];
			if (r >= N || r < 0 || c >= M || c < 0)
				break;
			if (temp[r][c] == 6)
				break;
			temp[r][c] = -1;
		}
	}

	static int solve() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++)
			temp[i] = Arrays.copyOf(map[i], M);

		for (int i = 0; i < p.size(); i++) {
			pump nowPump = p.get(i);
			int r = nowPump.r;
			int c = nowPump.c;
			int d = dir[i];
			if (nowPump.shape == 1) {
				spread(temp, r, c, d);
			} else if (nowPump.shape == 2) {
				if (d % 2 == 0) {
					spread(temp, r, c, 0);
					spread(temp, r, c, 2);
				} else {
					spread(temp, r, c, 1);
					spread(temp, r, c, 3);
				}
			} else if (nowPump.shape == 3) {
				spread(temp, r, c, d % 4);
				spread(temp, r, c, (d + 1) % 4);
			} else if (nowPump.shape == 4) {
				spread(temp, r, c, d % 4);
				spread(temp, r, c, (d + 1) % 4);
				spread(temp, r, c, (d + 2) % 4);
			} else if (nowPump.shape == 5) {
				for (int s = 0; s < 4; s++)
					spread(temp, r, c, s);
			}
		}

		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0)
					res++;
			}
		}

		return res;
	}

	static void dfs(int n) {
		if (n == p.size()) {
			int res = solve();
			result = result > res ? res : result;
			return;
		}

		for (int i = 0; i < 4; i++) {
			dir[n] = i;
			dfs(n + 1);
		}
	}
}

class pump {
	int r, c, shape;

	public pump(int r, int c, int shape) {
		this.r = r;
		this.c = c;
		this.shape = shape;
	}
}
