package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Programers_ªÔ∞¢¥ﬁ∆ÿ¿Ã {
	static int[] dr = { 1, 0, -1 };
	static int[] dc = { 0, 1, -1 };

	public int[] solution(int n) {
		int[][] map = new int[n][n];
		int dir = 1;
		int r = 0;
		int c = 0;
		int num = 1;
		int nextR = 0;
		int nextC = 0;
		int finish = 0;
		for (int i = 1; i <= n; i++)
			finish += i;
		finish++;

		while (true) {
			map[r][c] = num++;
			if (num == finish)
				break;
			nextR = r + dr[dir];
			nextC = c + dc[dir];
			if (nextR >= n || nextC >= n || map[nextR][nextC] != 0) {
				dir = (dir + 1) % 3;
			}
			r += dr[dir];
			c += dc[dir];
		}
		int[] answer = new int[finish - 1];
		ArrayList<Integer> ar = new ArrayList<>();
		Collections.sort(ar, (a, b) -> a - b);
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0)
					answer[index++] = map[i][j];
			}
		}
		return answer;
	}
}
