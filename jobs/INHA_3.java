package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class INHA_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[] A = bf.readLine().toCharArray();
		char[] B = bf.readLine().toCharArray();
		char[] newA = new char[A.length + 1];
		for (int i = 1; i < newA.length; i++) {
			newA[i] = A[i - 1];
		}
		char[] newB = new char[B.length + 1];
		for (int i = 1; i < newB.length; i++) {
			newB[i] = B[i - 1];
		}
		System.out.println(levenshteinDistance(newA, newB));

	}

	static public int getMinimum(int val1, int val2, int val3) {
		int minNumber = val1;
		if (minNumber > val2)
			minNumber = val2;
		if (minNumber > val3)
			minNumber = val3;
		return minNumber;
	}

	static public int levenshteinDistance(char[] s, char[] t) {
		int m = s.length;
		int n = t.length;

		int[][] d = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			d[i][0] = i;
		}

		for (int j = 1; j <= n; j++) {
			d[0][j] = j;
		}

		for (int j = 1; j < n; j++) {
			for (int i = 1; i < m; i++) {
				if (s[i] == t[j]) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					if (s[i] == 'i' && (t[j] == 'j' || t[j] == 'l')) {
						d[i][j] = d[i - 1][j - 1];
					} else if (s[i] == 'v' && t[j] == 'w') {
						d[i][j] = d[i - 1][j - 1];
					} else {
						d[i][j] = getMinimum(d[i - 1][j], d[i][j - 1], d[i - 1][j - 1]) + 1;
					}
				}
			}
		}
		return d[m - 1][n - 1];
	}
}
