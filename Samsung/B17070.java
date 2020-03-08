package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17070 {
	// 1:30 시작 40분 커트
	static int result;
	static int[] dc = { 1, 1, 0 }, dr = { 0, 1, 1 };// 오른쪽, 오른쪽아래, 아래

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int size = Integer.parseInt(st.nextToken());
		int[][] map = new int[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // == 1 ? -1 : Integer.parseInt(st.nextToken());
			}
		}
		recur(0, 1, 1, map);
		System.out.println(result);
	}

	static void recur(int r, int c, int shape, int[][] map) {
		// 기저
		if (r == map.length - 1 && c == map.length - 1) {
			result++;
			return;
		}
		if (c == map.length || r == map.length)
			return;

		// 실행
		// if (shape == 1 && c + 1 < map.length) {
		// if (map[r][c + 1] != 1)
		// recur(r, c + 1, 1, map);
		// if (r + 1 < map.length && map[r + 1][c + 1] != 1 && map[r + 1][c] != 1 &&
		// map[r][c + 1] != 1)
		// recur(r + 1, c + 1, 3, map);
		// } else if (shape == 2) {
		// if (r + 1 < map.length && map[r + 1][c] != 1)
		// recur(r + 1, c, 2, map);
		// if (r + 1 < map.length && c + 1 < map.length && map[r + 1][c + 1] != 1 &&
		// map[r + 1][c] != 1 && map[r][c + 1] != 1)
		// recur(r + 1, c + 1, 3, map);
		// } else if (shape == 3) {
		// if ( c + 1 < map.length && map[r][c + 1] != 1 )
		// recur(r, c + 1, 1, map);
		// if ( r + 1 < map.length && map[r + 1][c] != 1)
		// recur(r + 1, c, 2, map);
		// if (r + 1 < map.length && c + 1 < map.length && map[r + 1][c + 1] != 1 &&
		// map[r + 1][c] != 1 && map[r][c + 1] != 1)
		// recur(r + 1, c + 1, 3, map);
		// }
		// 중복을 최대한 줄이기 여기서 중복은 일단 recur 과 번위 체크
		if (r + 1 < map.length && c + 1 < map.length && map[r + 1][c + 1] != 1 && map[r + 1][c] != 1
				&& map[r][c + 1] != 1)
			recur(r + 1, c + 1, 3, map);
		if (shape != 1 && r + 1 < map.length && map[r + 1][c] != 1)
			recur(r + 1, c, 2, map);
		if (shape != 2 && c + 1 < map.length && map[r][c + 1] != 1)
			recur(r, c + 1, 1, map);
	}
}
