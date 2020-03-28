package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class empty {
	static boolean[] vtemp;
	static int[] problem;
	static int a, b;
	static int[][] map;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		map = new int[a][b];
		vtemp = new boolean[a];
		problem = new int[b + 1];
		for (int i = 0; i < a; i++) {
			String[] str = bf.readLine().split("");
			for (int j = 0; j < b; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		for (int i = 0; i < a; i++) {
			for (int j = i + 1; j < a; j++) {
				int[] temp = new int[b];
				for (int k = 0; k < b; k++) {
					if (map[i][k] == 1)
						temp[k]++;
				}
				for (int k = 0; k < b; k++) {
					if (map[j][k] == 1)
						temp[k]++;
				}
				int zerocnt = 0;
				for (int k = 0; k < b; k++) {
					if (temp[k] == 0)
						zerocnt++;
				}
				problem[(b - zerocnt)]++;
				max = max < (b - zerocnt) ? (b - zerocnt) : max;
			}
		}
		System.out.println(max);
		System.out.println(problem[max]);
	}

}
