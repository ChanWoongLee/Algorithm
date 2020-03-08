package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class SWE1954 {
	static int[] dx = { 0, 1, 0, -1 };// 오른쪽 아래 왼쪽 위
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		ArrayList<Integer> nn = new ArrayList();
		for(int i = 0; i < testcase; i++) {
			nn.add(sc.nextInt());
		}
		int result = 0;
		while (testcase-- > 0) {
			int n = nn.get(result);
			int[][] snail = new int[n][n];
			int row = 0;
			int col = 0;
			int count = 1;
			snail[row][col] = count;
			int stop = 1;
			int i = 0;
			while (stop != n * n) {
				if (i == 4)
					i = 0;
				if (row + dx[i] >= 0 && row + dx[i] < n && col + dy[i] >= 0 && col + dy[i] < n
						&& snail[row + dx[i]][col + dy[i]] == 0) {
					snail[row + dx[i]][col + dy[i]] = ++count;
					stop++;
					row = row +dx[i];
					col = col + dy[i];
				} else
					i++;
			}
			System.out.println("#"+(result+1));
			result++;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (k == n - 1)
						System.out.print(snail[j][k]);
					else
						System.out.print(snail[j][k] + " ");
				}
					System.out.println();
			}
		}
	}
}
