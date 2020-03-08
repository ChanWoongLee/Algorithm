package Olim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10163 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[][] map = new int[102][102];
		for (int i = 1; i <= num; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int row_length = Integer.parseInt(st.nextToken());
			int col_length = Integer.parseInt(st.nextToken());

			for (int j = r; j < r + row_length; j++) {
				for (int k = c; k < c + col_length; k++) {
					map[j][k] = i;
				}
			}
		}
		int[] result = new int[num+1];
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if(map[i][j] != 0)
					result[map[i][j]]++;
			}
		}
		for(int i = 1; i <= num; i++) {
			System.out.println(result[i]);
		}
	}
}
