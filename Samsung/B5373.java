package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5373 {
	static String[][][] cube = new String[6][3][3];
	static String[] color = { "w", "y", "r", "o", "g", "b" };

	public static void main(String[] args) throws IOException {

		int[] rotate1 = { 4, 1, 5, 0 };
		int[] reverse1 = { 0, 5, 1, 4 };
		int[] rotate2 = { 0, 3, 1, 2 };
		int[] reverse2 = { 2, 1, 3, 0 };
		int[] rotate3 = { 5, 3, 4, 2 };
		int[] reverse3 = { 5, 2, 4, 3 };
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int Testcase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= Testcase; t++) {
			for (int i = 0; i < 6; i++) {
				String now = color[i];
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						cube[i][j][k] = now;
					}
				}
			}
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < num; i++) {
				String[] str = st.nextToken().split("");
				int[] r = null;
				if (str[0].equals("F")) {
					if (str[1].equals("+"))
						rotate1(rotate1, 2);
					else
						rotate1(reverse1, 2);
				} else if (str[0].equals("B")) {
					if (str[1].equals("+"))
						rotate1(reverse1, 0);
					else
						rotate1(rotate1, 0);
				} else if (str[0].equals("L")) {
					if (str[1].equals("+"))
						rotate2(rotate2, 0);
					else
						rotate2(reverse2, 0);
				} else if (str[0].equals("R")) {
					if (str[1].equals("+"))
						rotate2(rotate2, 2);
					else
						rotate2(reverse2, 2);
				} else if (str[0].equals("U")) {//윗면
					if (str[1].equals("+"))
						rotate3(reverse3, 2, "+");// 5243 2 
					else
						rotate3(rotate3, 2, "-");//5342 2
				} else if (str[0].equals("D")) {
					if (str[1].equals("+"))
						rotate3(rotate3, 0, "+");//5342 0 
					else
						rotate3(reverse3, 0, "-");//5243 0
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(cube[0][i][j]);
				}
				System.out.println();
			}

		}
	}

	static void rotate1(int[] r, int line) {
		String[] temp = new String[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cube[r[0]][line][i];
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[r[i]][line][j] = cube[r[i + 1]][line][j];
			}
		}
		for (int i = 0; i < 3; i++) {
			cube[r[3]][line][i] = temp[i];
		}
	}

	static void rotate2(int[] r, int line) {
		String[] temp = new String[3];
		for (int i = 0; i < 3; i++) {
			temp[i] = cube[r[0]][i][line];
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[r[i]][j][line] = cube[r[i + 1]][j][line];
			}
		}
		for (int i = 0; i < 3; i++) {
			cube[r[3]][i][line]=temp[i];
		}
	}

	static void rotate3(int[] r, int line, String str) {//5243  5342
		String[][] temp = new String[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j <3 ;j++) {
				temp[i][j] = cube[r[0]][i][j];
			}
		}
		if (str.equals("-")) {
			if (line == 0) {// D 의 반시계 5243
				cube[r[0]][0][0] = cube[r[3]][2][0];
				cube[r[0]][1][0] = cube[r[3]][2][1];
				cube[r[0]][2][0] = cube[r[3]][2][2];

				cube[r[3]][2][0] = cube[r[2]][2][2];
				cube[r[3]][2][1] = cube[r[2]][1][2];
				cube[r[3]][2][2] = cube[r[2]][0][2];

				cube[r[2]][2][2] = cube[r[1]][0][2];
				cube[r[2]][1][2] = cube[r[1]][0][1];
				cube[r[2]][0][2] = cube[r[1]][0][0];

				cube[r[1]][0][2] = temp[0][0];
				cube[r[1]][0][1] = temp[1][0];
				cube[r[1]][0][0] = temp[2][0];

			} else { // U의 반시계  5342
				cube[r[0]][0][2] = cube[r[3]][2][2];
				cube[r[0]][1][2] = cube[r[3]][2][1];
				cube[r[0]][2][2] = cube[r[3]][2][0];

				cube[r[3]][2][0] = cube[r[2]][0][0];
				cube[r[3]][2][1] = cube[r[2]][1][0];
				cube[r[3]][2][2] = cube[r[2]][2][0];

				cube[r[2]][2][0] = cube[r[1]][0][0];
				cube[r[2]][1][0] = cube[r[1]][0][1];
				cube[r[2]][0][0] = cube[r[1]][0][2];

				cube[r[1]][0][0] = temp[0][2];
				cube[r[1]][0][1] = temp[1][2];
				cube[r[1]][0][2] = temp[2][2];
			}
		} else {
			if (line == 0) {// D 의 시계 5342
				cube[r[0]][0][0] = cube[r[3]][0][2];
				cube[r[0]][1][0] = cube[r[3]][0][1];
				cube[r[0]][2][0] = cube[r[3]][0][0];

				cube[r[3]][0][0] = cube[r[2]][0][2];
				cube[r[3]][0][1] = cube[r[2]][1][2];
				cube[r[3]][0][2] = cube[r[2]][2][2];

				cube[r[2]][0][2] = cube[r[1]][2][2];
				cube[r[2]][1][2] = cube[r[1]][2][1];
				cube[r[2]][2][2] = cube[r[1]][2][0];

				cube[r[1]][2][2] = temp[2][0];
				cube[r[1]][2][1] = temp[1][0];
				cube[r[1]][2][0] = temp[0][0];

			} else {// U의 시계  5243
				cube[r[0]][0][2] = cube[r[3]][0][0];
				cube[r[0]][1][2] = cube[r[3]][0][1];
				cube[r[0]][2][2] = cube[r[3]][0][2];

				cube[r[3]][0][0] = cube[r[2]][2][0];
				cube[r[3]][0][1] = cube[r[2]][1][0];
				cube[r[3]][0][2] = cube[r[2]][0][0];

				cube[r[2]][0][0] = cube[r[1]][2][0];
				cube[r[2]][1][0] = cube[r[1]][2][1];
				cube[r[2]][2][0] = cube[r[1]][2][2];

				cube[r[1]][2][0] = temp[2][2];
				cube[r[1]][2][1] = temp[1][2];
				cube[r[1]][2][2] = temp[0][2];
			}
		}

	}
}
