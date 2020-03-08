package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17256_verygood {
	static String[][] map;
	static int x = 0, y = 0;
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int now;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int mapSize = Integer.parseInt(bf.readLine());
		map = new String[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = st.nextToken();
			}
		}
		dfs(0,0,Integer.valueOf(map[0][0]));
		System.out.println(max+" "+min);
	}

	static void dfs(int x, int y, int now) {
		if (x + 2 < map.length) {
			dfs(x + 2, y, compute(now, map[x + 2][y], map[x + 1][y]));
		}
		if (x + 1 < map.length && y + 1 < map.length) {
			dfs(x + 1, y + 1, compute(now, map[x + 1][y + 1], map[x + 1][y]));
			dfs(x + 1, y + 1, compute(now, map[x + 1][y + 1], map[x][y + 1]));
		}
		if (y + 2 < map.length) {
			dfs(x, y + 2, compute(now, map[x][y + 2], map[x][y + 1]));
		}

		if (x == map.length - 1 && y == map.length - 1) {
			if (max < now)
				max = now;
			if (min > now)
				min = now;
		}
	}

	static int compute(int now, String a, String cal) {
		if (cal.equals("+"))
			return now + Integer.valueOf(a);
		else if (cal.equals("-"))
			return now - Integer.valueOf(a);
		else
			return now * Integer.valueOf(a);
	}
}
