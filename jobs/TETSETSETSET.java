package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TETSETSETSET {
	static int result;
	static int[] line0 = { 0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000 };
	static int[] line1 = { 50, 275, 250, 300, 150, 175, 75, 80, 85, 90, 95, 500, 1000 };
	static int[] line2 = { 300, 350, 400, 500, 1000 };
	static int[] line3 = { 100, 150, 125, 300, 350, 400, 500, 1000 };
	// 1000 제외 생각하기
	static int[][] person = new int[4][2];
	static int[] move = new int[10];
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= testCase; i++) {
			result = 0;
			visit = new boolean[1001];
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 2; k++) {
					person[j][k] = 0;
				}
			}
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 10; j++)
				move[j] = Integer.parseInt(st.nextToken());

			dfs(0, 0, 0);
			System.out.println("#" + i + " " + result);

		}
	}

	static void dfs(int m, int p, int res) {
		if (m == 10) {
			result = result < res ? res : result;
			return;
		}
		int state = person[p][0];
		int loc = person[p][1];
		// 다왔을때
		if (state == 0 && line0[loc] == 1000)
			return;
		if (state == 1 && line1[loc] == 1000)
			return;
		if (state == 2 && line2[loc] == 1000)
			return;
		if (state == 3 && line3[loc] == 1000)
			return;

		int nextloc = loc + move[m];
		int nextstate = state;

		// 결승선 초과시 도착지점에 맞춤
		if (state == 0 && nextloc >= line0.length) {
			nextloc = 4;
			nextstate = 2;
		}
		if (state == 1 && nextloc >= line1.length) {
			nextloc = 4;
			nextstate = 2;
		}
		if (state == 2 && nextloc >= line2.length) {
			nextloc = 4;
			nextstate = 2;
		}
		if (state == 3 && nextloc >= line3.length) {
			nextloc = 4;
			nextstate = 2;
		}
		// 특수한경우의 말이동
		if (state == 0 && nextloc == 5) {
			nextloc = 0;
			nextstate = 1;
		} else if (state == 0 && nextloc == 10) {
			nextstate = 3;
			nextloc = 0;
		} else if (state == 1 && nextloc == 3) {
			nextstate = 2;
			nextloc = 0;
		}

		int score = 0;
		if (nextstate == 0) {
			score = line0[nextloc];
		} else if (nextstate == 1) {
			score = line1[nextloc];
		} else if (nextstate == 2) {
			score = line2[nextloc];
		} else if (nextstate == 3) {
			score = line3[nextloc];
		}

		if (score != 1000 && visit[score])
			return;

		// 이동 성공시
		person[p][0] = nextstate;
		person[p][1] = nextloc;
		visit[score] = true;
		int newres = res + score;
		System.out.println(m+" "+p+" "+newres);
		for (int i = 0; i < 4; i++) {
			dfs(m + 1, i, newres);
		}

		visit[score] = false;
		person[p][0] = state;
		person[p][1] = loc;
	}
}
