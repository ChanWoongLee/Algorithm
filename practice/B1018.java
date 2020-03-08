package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B1018 {
	static int resut = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = bf.read();
		int M = bf.read();
		int result = 0;
		String[][] B = new String[N][M];
		for (int i = 0; i < N; i++) {
			String[] Bline = bf.readLine().split("");
			for(int j = 0; j< M; j++) {
				B[i][j] = Bline[j];
			}
		}

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
					result = checkBoa
							rdFirstB(B, i, j);
			}
		}
		System.out.println(result);
	}

	public static int checkBoardFirstB(String[][] B, int x, int y) {
		int reverse = 0;
		int changeNumber = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (reverse == 0) {
					if (B[i][j] != "B") {
						changeNumber++;
						reverse = 1;
					}
				}
				if (reverse == 1) {
					if (B[i][j] != "W") {
						changeNumber++;
						reverse = 0;
					}
				}
			}
		}
		return changeNumber;

	}
}
