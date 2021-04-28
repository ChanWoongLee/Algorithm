package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class INHA_D {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] str;
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			str = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int[][] ans = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] < 0) {
					ans[i + m / 2][j + m / 2] += -(arr[i][j]);
					int temp = arr[i][j];
					int r_l = i + m;
					int c_l = j + m;
					for (int r = i; r < r_l; r++) {
						for (int c = j; c < c_l; c++) {
							arr[r][c] += -(temp);
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

}
