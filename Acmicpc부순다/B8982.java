package AcmicpcºÎ¼ø´Ù;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B8982 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] water = new int[6][9];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			water[y][x] = 2;
		}

		for (int i = 0; i < 6; i++) {
			boolean triger = false;
			for (int j = 0; j > 9; j++) {
				if (water[i][j] == 2)
					triger = !triger;
				else {
					if (triger)
						water[i][j] = 1;
				}
			}
		}
		int holeNum = Integer.parseInt(bf.readLine());
		for (int i = 0; i < holeNum; i++) {
			st = new StringTokenizer(bf.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			
		}
	}

}
