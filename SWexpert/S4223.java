package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4223 {
	// 8 : 11
	static int[] check;
	static int[] score;
	static int[][] name;
	static int[] target = new int[30];
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(bf.readLine());
		String correct = "SAMSUNG";
		for (int i = 0; i < correct.length(); i++) {
			target[correct.charAt(i) - 'A']++;
		}
		for (int t = 1; t <= testCase; t++) {
			int N = Integer.parseInt(bf.readLine());
			check = new int[30];
			name = new int[N][30];
			score = new int[N];
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int L = Integer.parseInt(bf.readLine());
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < L; j++) {
					int indx = st.nextToken().charAt(0) - 'A';
					name[i][indx]++;
				}
				score[i] = Integer.parseInt(bf.readLine());
			}
			recur(0, 0);
			if (result == Integer.MAX_VALUE)
				System.out.println("#" + t + " " + "-1");
			else
				System.out.println("#" + t + " " + result);
		}
	}

	static void visit(int idx, boolean b) {
		for (int i = 0; i < 30; i++) {
			if (name[idx][i] != 0) {
				if (b)
					check[i] += name[idx][i];
				else
					check[i] -= name[idx][i];
			}
		}
	}

	static boolean same() {
		for (int i = 0; i < 30; i++) {
			if (target[i] > check[i]) {
				return false;
			}
		}
		return true;
	}

	static void recur(int index, int cnt) {
		if (index == score.length) {
			if (same()) {
				result = result > cnt ? cnt : result;
				return;
			}
			return;
		}
		visit(index, true);
		recur(index + 1, cnt + score[index]);
		visit(index, false);
		recur(index + 1, cnt);
	}
}
