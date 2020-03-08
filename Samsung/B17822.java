package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import AlgoStudy.codeForce1;

public class B17822 {
	// 10 : 51 시작
	static int[][] pan;
	static int[][] move;
	static int[] ma = { 1, 0, -1, 0 };// 위 오른쪽 아래 왼쪽
	static int[] mb = { 0, 1, 0, -1 };
	static boolean change = false;
	static boolean changed = false;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		pan = new int[N + 1][M];
		int T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move = new int[T][3];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < T; i++) {
			changed = false;
			rotate(move[i][0], move[i][1], move[i][2]);
			int sum = 0;
			int n = 0;
			visit = new boolean[pan.length][pan[0].length];
			for (int a = 1; a < pan.length; a++) {
				for (int b = 0; b < pan[0].length; b++) {
					if (pan[a][b] != 0 && !visit[a][b]) {
						sum += pan[a][b];
						change = false;
						dfs(a, b);
						if (change)
							changed = true;
						n++;
					}
				}
			}
			if (changed == false && n != 0) {
				for (int a = 1; a < pan.length; a++) {
					for (int b = 0; b < pan[0].length; b++) {
						if(pan[a][b] == 0)
							continue;
						if (pan[a][b] > ((double)sum / (double)n)) {
							pan[a][b] = pan[a][b] - 1;
						} else if (pan[a][b] < ((double)sum / (double)n)) {
							pan[a][b] = pan[a][b] + 1;
						}
					}
				}
			}

			change = false;
	
		}
		int result = 0;
		for (int a = 1; a < pan.length; a++) {
			for (int b = 0; b < pan[0].length; b++) {
				result += pan[a][b];
			}
		}
		System.out.println(result);
	}

	static void dfs(int a, int b) {

		visit[a][b] = true;
		int value = pan[a][b];
		if (change)
			pan[a][b] = 0;

		for (int i = 0; i < 4; i++) {
			int nextA = a + ma[i];
			int nextB = b + mb[i];
			if (nextA == pan.length || nextA == 0)
				continue;
			if (nextB >= pan[0].length)
				nextB = 0;
			else if (nextB < 0)
				nextB = pan[0].length - 1;

			if (visit[nextA][nextB])
				continue;

			if (pan[nextA][nextB] == value) {
				change = true;
				pan[a][b] = 0;
				dfs(nextA, nextB);
			}
		}
	}

	static void rotate(int p, int dir, int move) {

		for (int i = 1; i <= pan.length-1; i++) {
			if (i % p == 0) {
				if (dir == 0) {
					LinkedList<Integer> q = new LinkedList();
					for (int len = 0; len < pan[0].length; len++)
						q.addLast(pan[i][len]);
					for (int m = 1; m <= move; m++)
						q.addFirst(q.pollLast());
					for (int len = 0; len < pan[0].length; len++)
						pan[i][len] = q.pollFirst();
				} // 시계방향
				else {
					LinkedList<Integer> q = new LinkedList();
					for (int len = 0; len < pan[0].length; len++)
						q.addLast(pan[i][len]);
					for (int m = 1; m <= move; m++)
						q.addLast(q.pollFirst());
					for (int len = 0; len < pan[0].length; len++)
						pan[i][len] = q.pollFirst();
				} // 반시계
			} // 회전판검색
		}
	}
}
