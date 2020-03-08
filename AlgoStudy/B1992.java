package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1992 {
	static int[][] display;
	static int N;

	// 나눠지는건 N*N이 4등분으로
	public static void divide(int startX, int startY, int length) {
		if (length == 1) {
			System.out.print(display[startX][startY]);
			return;
		}
		int check = display[startX][startY];
		boolean allSame = true;
		for (int i = startX; i < startX + length; i++) {
			for (int j = startY; j < startY + length; j++) {
				if (check != display[i][j]) {
					allSame = false;
					break;
				}
			}
		}
		if (allSame) 
			System.out.print(display[startX][startY]);
		else {
			System.out.print("(");
			divide(startX, startY, length / 2);
			divide(startX, startY + length / 2, length / 2);
			divide(startX + length / 2, startY, length / 2);
			divide(startX + length / 2, startY + length / 2, length / 2);
			System.out.print(")");
		}
	}

	static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		char[] low = null;
		display = new int[N][N];
		sb = new StringBuffer();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			low = st.nextToken().toCharArray();
			for (int j = 0; j < N; j++) {
				display[i][j] = Integer.parseInt(low[j] + "");
			}
		}
			divide(0, 0, N);
	}
}
