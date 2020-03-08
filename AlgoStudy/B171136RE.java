package AlgoStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B171136RE {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] paper = new int[5];
		for (int i = 0; i < 5; i++) {
			paper[i] = 6;
		}
	}

}
