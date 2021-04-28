package NoneStop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_гу╫бец╫ц©Д╠щ_dijk {

	public static void main(String[] args) {
		solution(6, 4, 6, 2, new int[][] { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 },
				{ 4, 6, 50 }, { 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } });
	}

	static int[][] costs;
	static int[][] map;

	static public int solution(int n, int s, int a, int b, int[][] fares) {
		map = new int[n + 1][n + 1];
		costs = new int[n + 1][n + 1];
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
		for (int i = 0; i < costs.length; i++) {
			Arrays.fill(costs[i], 10000000);
		}
		dijk(s);
		dijk(a);
		dijk(b);

		int ans = costs[s][a] + costs[s][b];
		for (int i = 1; i <= n; i++) {
			ans = Math.min(ans, costs[s][i] + costs[i][a] + costs[i][b]);
		}
		return ans;
	}

	static void dijk(int start) {
		costs[start][start] = 0;
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(start, 0));
		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 1; i < map.length; i++) {
				if (costs[start][i] > map[now.node][i] + now.cost) {
					costs[start][i] = map[now.node][i] + now.cost;
					costs[i][start] = map[now.node][i] + now.cost;
					q.add(new Pos(i, map[now.node][i] + now.cost));
				}
			}
		}
	}

	static class Pos {
		int node, cost;

		public Pos(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}

	}
}
