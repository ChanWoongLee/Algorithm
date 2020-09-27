package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10 30 시작
public class B17281 {
	static int N;
	static int[][] ining;
	static boolean[] visit;
	static int[] player;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		ining = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 9; j++) {
				ining[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[9];
		player = new int[9];
		player[3] = 0;
		recur(0);
		System.out.println(result);
	}

	//
	// static void solve() {
	//
	// int score = 0;
	// int num = 0;
	// Queue<Integer> basball = new LinkedList<Integer>();
	// for (int i = 0; i < N; i++) {
	// int out = 0;
	// basball.clear();
	// basball.add(0);
	// basball.add(0);
	// basball.add(0);
	// while (true) {
	// int act = ining[i][player[num]];
	// if (act == 0) {
	// out++;
	// if (out == 3)
	// break;
	// } else {
	// for (int a = 0; a < act; a++) {
	// score += basball.poll();
	// if (a == 0)
	// basball.add(1);// 처음만 선수넣기
	// else
	// basball.add(0);
	// }
	// }
	// num++;
	// if (num == 9)
	// num = 0;
	// }
	// num++;
	// if (num == 9)
	// num = 0;
	// }
	// result = score > result ? score : result;
	// }
	static void calc() {
		int startNum = 0;
		int score = 0;
		for (int i = 0; i < N; i++) {
			int[] pt = { 0, 0, 0, 0, 0 };

			while (pt[0] < 3) {
				run(pt, ining[i][player[startNum]]);
				startNum++;
				if (startNum == 9) {
					startNum = 0;
				}
			}
			score += pt[4];
		}
		result = score > result ? score : result;
	}

	static void run(int[] pt, int num) {
		for (int n = 0; n < num; n++) {
			pt[4] += pt[3];
			pt[3] = pt[2];
			pt[2] = pt[1];
			pt[1] = 0;
		}
		pt[num]++;
	}

	static void recur(int cnt) {
		if (cnt == 9) {
			// calc();
			for (int i : player)
				System.out.print(i + " ");
			System.out.println();
			return;
		}
		if (cnt == 3) {
			recur(cnt + 1);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visit[i] || i == 0)
				continue;
			visit[i] = true;
			player[cnt] = i;
			recur(cnt + 1);
			visit[i] = false;

		}

	}
}
