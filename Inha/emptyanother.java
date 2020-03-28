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

		johab(0, 0);
		System.out.println(max);
		System.out.println(problem[max]);
	}

	static void johab(int index, int cnt) {
		if (cnt == 2) {
			int[] temp = new int[b];
			for (int i = 0; i < a; i++) {
				if (vtemp[i] == true) {
					for (int j = 0; j < b; j++) {
						if (map[i][j] == 1)
							temp[j]++;
					}
				}
			}
			int zerocnt = 0;
			for (int i = 0; i < b; i++) {
				if (temp[i] == 0)
					zerocnt++;
			}
			problem[(b - zerocnt)]++;
			max = max < (b - zerocnt) ? (b - zerocnt) : max;
			return;
		}
		if (index == a)
			return;
		vtemp[index] = true;
		johab(index + 1, cnt + 1);
		vtemp[index] = false;
		johab(index + 1, cnt);
	}
}
