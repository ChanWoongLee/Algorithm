package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.omg.PortableInterceptor.DISCARDING;

public class SW1249 {
	static int map[][];
	static int dikstra[][];
	static int[] dx = { -1, 0, 1, 0 };// 위 오른쪽 아래 왼쪽
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		int count = 1;
		while (testcase-- > 0) {
			int mapSize = Integer.parseInt(bf.readLine());
			map = new int[mapSize][mapSize];
			dikstra = new int[mapSize][mapSize];
			for (int i = 0; i < mapSize; i++) {
				String[] st = bf.readLine().split("");
				for (int j = 0; j < mapSize; j++) {
					map[i][j] = Integer.parseInt(st[j]);
					dikstra[i][j] = 999999;
				}
			}
			dikstra[0][0] = map[0][0];
			dfs(0, 0);
			System.out.println("#" + count + " " + dikstra[mapSize-1][mapSize-1]);
			count += 1;
		}
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			if (x + dx[i] < map.length && y + dy[i] < map.length && x + dx[i] >= 0 && y + dy[i] >= 0) {
				if (map[x + dx[i]][y + dy[i]] + dikstra[x][y] < dikstra[x + dx[i]][y + dy[i]]) {
					dikstra[x + dx[i]][y + dy[i]] = map[x + dx[i]][y + dy[i]] + dikstra[x][y];
					dfs(x + dx[i], y + dy[i]);
				}
			}
		}
	}
}