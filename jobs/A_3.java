package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_3 {
	static int[] line0 = { 0, 5, 10, 15, 20, 50, 30, 35, 40, 45, 100, 55, 60, 65, 70, 75, 80, 85, 90, 95, 500, 1000,
			275, 250, 300, 150, 175, 150, 125, 350, 400 };
	static int[][] m = new int[35][6];
	static int[][] temp = { { 5, 22, 23, 24, 25, 26 }, { 22, 23, 24, 25, 26, 15 }, { 23, 24, 25, 26, 15, 16 },
			{ 24, 29, 30, 20, 21, 21 }, { 25, 26, 15, 16, 17, 18 }, { 26, 15, 16, 17, 18, 19 },
			{ 10, 27, 28, 24, 29, 30 }, { 27, 28, 24, 29, 30, 20 }, { 28, 24, 29, 30, 20, 21 },
			{ 29, 30, 20, 21, 21, 21 }, { 30, 20, 21, 21, 21, 21 }, };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
				m[temp[i][0]][j] = temp[i][j];
			}
		}
		int now = 0;
		for (int i = 0; i < n; i++) {
			int move = Integer.parseInt(st.nextToken());
			if (m[now][move] != 0) {
				now = m[now][move];
				System.out.print(line0[now] + " ");
			} else {
				now += move;
				if (now >= 21) {
					System.out.print("1000");
					return;
				} else {
					System.out.print(line0[now] + " ");
				}
			}

		}

	}

}
