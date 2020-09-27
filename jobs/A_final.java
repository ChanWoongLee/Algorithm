package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_final {
	static int result;
	static int[] line = { 0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000, 275,
			250, 300, 150, 175, 150, 125, 350, 400 };
	static int[][] temp = { { 5, 22, 23, 24, 25, 26 }, { 22, 23, 24, 25, 26, 15 }, { 23, 24, 25, 26, 15, 16 },
			{ 24, 29, 30, 20, 21, 21 }, { 25, 26, 15, 16, 17, 18 }, { 26, 15, 16, 17, 18, 19 },
			{ 10, 27, 28, 24, 29, 30 }, { 27, 28, 24, 29, 30, 20 }, { 28, 24, 29, 30, 20, 21 },
			{ 29, 30, 20, 21, 21, 21 }, { 30, 20, 21, 21, 21, 21 }, };
	static int[][] m = new int[35][6];
	static int[] move = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		for (int i = 0; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
				m[temp[i][0]][j] = temp[i][j];
			}
		}

		for (int i = 1; i <= testCase; i++) {
			result = 0;
			int[] person = new int[4];
			boolean[] visit = new boolean[35];
			st = new StringTokenizer(bf.readLine());
			for (int k = 0; k < 10; k++) {
				move[k] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, 0, person, visit);
			System.out.println("#" + i + " " + result);
		}
	}

	static void dfs(int n, int p, int res, int[] person, boolean[] visit) {
		int now = person[p];
		int initloc = person[p];
		int moving = move[n];

		if (now == 21)
			return;

		if (m[now][moving] != 0) {
			now = m[now][moving];
		} else {
			now += moving;
			if (now >= 21)
				now = 21;
		}

		if (visit[now])
			return;
		else
			visit[initloc] = false;

		person[p] = now;
		visit[now] = true;
		int score = res + line[now];
		 for (int a : person) {
		 System.out.print(a + " ");
		 }
		 System.out.println(" " + line[now] + " " + score);
		int[] newperson = Arrays.copyOf(person, 4);
		boolean[] newvisit = Arrays.copyOf(visit, 35);

		if (n == 9) {
			result = res > result ? res : result;
			return;
		}
		for (int i = 0; i < 4; i++) {
			dfs(n + 1, i, score, newperson, newvisit);
		}
		// person[p] = initloc;
		// visit[initloc] = true;
		// visit[now] = false;
	}
}
