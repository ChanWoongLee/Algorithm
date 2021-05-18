package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B11404 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[][] grahp2 = new int[n + 1][n + 1];

		for(int i =1 ; i <= n ; i++) {
			for(int j =1; j <= n ; j ++) {
				if(i == j)
					continue;
				grahp2[i][j] = 987654321;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			grahp2[start][end] = Math.min(value, grahp2[start][end]);
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (grahp2[i][j] > grahp2[i][k] + grahp2[k][j])
						grahp2[i][j] = grahp2[i][k] + grahp2[k][j];
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (grahp2[i][j] == 987654321)
					System.out.println("0 ");
				else
					System.out.print(grahp2[i][j] + " ");
			}
			System.out.println();
		}
	}

}
