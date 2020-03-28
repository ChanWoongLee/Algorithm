package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1525 {
	static int[][] map = new int[3][3];
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };// 위 오른쪽 아래 왼쪽
	static int[][] correct = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

	public static void main(String[] args) throws IOException {
		String a = "d";
		a.
		StringBuilder st= new StringBuilder(a);
		st.
		System.out.println(st);
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int initR = 0;
//		int initC = 0;
//		for (int i = 0; i < 3; i++) {
//			String[] str = bf.readLine().split(" ");
//			for (int j = 0; j < 3; j++) {
//				map[i][j] = Integer.parseInt(str[j]);
//				if (map[i][j] == 0) {
//					initR = i;
//					initC = j;
//				}
//
//			}
//		}
		
		//dfs(initR, initC, 0);
	}

	static void dfs(int r, int c, int cnt) {
		if (same()) {
		}

	}

	static boolean same() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[i][j] != correct[i][j])
					return false;
			}
		}
		return true;
	}
}
