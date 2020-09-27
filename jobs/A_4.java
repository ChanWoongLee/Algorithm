package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_4 {
	static int[] person = new int[5];
	static int[] personScore = new int[5];
	static boolean[] visit = new boolean[35];
	static int[] line0 = { 0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000,
			275, 250, 300, 150, 175, 150, 125, 350, 400 };
	static int[][] temp = { { 5, 22, 23, 24, 25, 26 }, { 22, 23, 24, 25, 26, 15 }, { 23, 24, 25, 26, 15, 16 },
			{ 24, 29, 30, 20, 21, 21 }, { 25, 26, 15, 16, 17, 18 }, { 26, 15, 16, 17, 18, 19 },
			{ 10, 27, 28, 24, 29, 30 }, { 27, 28, 24, 29, 30, 20 }, { 28, 24, 29, 30, 20, 21 },
			{ 29, 30, 20, 21, 21, 21 }, { 30, 20, 21, 21, 21, 21 }, };
	static int[][] m = new int[35][6];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] move = new int[n];
		int[] movePerson = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			movePerson[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
				m[temp[i][0]][j] = temp[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			int moving = move[i];
			int now = person[movePerson[i]];
			int initloc = person[movePerson[i]];
			if (now == 21)
				continue;

			if (m[now][moving] != 0) {
				now = m[now][moving];
			} else {
				now += moving;
				if (now >= 21)
					now = 21;
			}

			if (visit[now]) {
				System.out.println("-1");
				return;
			} else
				visit[initloc] = false;

			person[movePerson[i]] = now;
			visit[now] = true;
		}
		int res = 0;
		for (int i = 0; i < person.length; i++) {
			res += line0[person[i]];
		}
		System.out.println(res);
	}

}
