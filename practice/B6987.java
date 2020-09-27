package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B6987 {
	static int[] temp = new int[6];
	static int[] temp2 = new int[6];
	static int[] win;
	static int[] lose;
	static int[] draw;
	static boolean finish;
	static boolean finish2;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(bf.readLine());
			finish = false;
			finish2 = false;
			int[][] score = new int[6][3];
			boolean initFinish = false;
			for (int j = 0; j < 6; j++) {
				score[j][0] = Integer.parseInt(st.nextToken());
				score[j][1] = Integer.parseInt(st.nextToken());
				score[j][2] = Integer.parseInt(st.nextToken());
				if (score[j][0] + score[j][1] + score[j][2] > 5) {
					System.out.print("0 ");
					initFinish = true;
				}
			}
			if(initFinish)
				continue;
			win = new int[6];
			for (int j = 0; j < 6; j++)
				win[j] = score[j][0];

			lose = new int[6];
			for (int j = 0; j < 6; j++)
				lose[j] = score[j][2];

			recur(0, 0, win[0], 0, "win");
			temp = new int[6];
			if (!finish) {
				System.out.print("0 ");
				continue;
			}
			draw = new int[6];
			for (int j = 0; j < 6; j++) {
				draw[j] = score[j][1];
			}
			recur(0, 0, draw[0], 0, "draw");
			temp = new int[6];
			if (finish && finish2)
				System.out.print("1 ");
			else
				System.out.print("0 ");

		}
	}

	static void recur(int index, int cnt, int maxCnt, int nowTeam, String what) {
		if (finish && what.equals("win"))
			return;
		if (finish2 && what.equals("draw"))
			return;
		if (cnt == maxCnt) {
			nowTeam++;
			
			if (nowTeam == 6) {
				if (what.equals("win")) {
					if (Arrays.equals(temp, lose))
						finish = true;
					return;
				} else if (what.equals("draw")) {
					if (Arrays.equals(temp, draw))
						finish2 = true;
					return;
				}
			}
			if (what.equals("win")) {
				recur(0, 0, win[nowTeam], nowTeam, what);
			} else if (what.equals("draw")) {
				recur(0, 0, draw[nowTeam], nowTeam, what);
			}
			return;

		}
		for (int i = index; i < 6; i++) {
			if (i == nowTeam)
				continue;

			temp[i]++;
			recur(i + 1, cnt + 1, maxCnt, nowTeam, what);
			if (finish && what.equals("win"))
				return;
			if (finish2 && what.equals("draw"))
				return;
			temp[i]--;
		}
	}
}
