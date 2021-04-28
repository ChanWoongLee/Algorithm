package NoneStop;

import java.util.Arrays;

public class P_합승택시요금_fluyd {
	// 풀루이드 N3 N=500 , 다익스트라 nlogn N=5000000
	public static void main(String[] args) {
		solution(6, 4, 6, 2, new int[][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 4}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
	}

	static public int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] map = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(map[i], 10000000);
		}
		for (int i = 0; i < n + 1; i++) {
			map[i][i] = 0;
		}
		for (int i = 0; i < fares.length; i++) {
			map[fares[i][0]][fares[i][1]] = fares[i][2];
			map[fares[i][1]][fares[i][0]] = fares[i][2];
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		int ans = map[s][a] + map[s][b];
		for (int i = 1; i <= n; i++) {
			ans = Math.min(ans, map[s][i] + map[i][a] + map[i][b]);
		}

		return ans;
	}

}
