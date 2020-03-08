package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.print.Doc;

public class B17265 {
	static String[][] map;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(bf.readLine());
		map = new String[size][size];
		dist = new int[size][size];
		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = st.nextToken();
				dist[i][j] = Integer.MIN_VALUE;
			}
		}


		dist[0][0] = Integer.parseInt(map[0][0]);
		PriorityQueue<Dot> pq = new PriorityQueue<>((a, b) -> -(a.value - b.value));
		pq.add(new Dot(0, 0, Integer.parseInt(map[0][0])));
		while (!pq.isEmpty()) {
			Dot dot = pq.poll();
			if (dot.x + 2 < map.length) {
				if (dist[dot.x + 2][dot.y] < cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 2][dot.y]),
						map[dot.x + 1][dot.y])) {
					dist[dot.x + 2][dot.y] = +cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 2][dot.y]),
							map[dot.x + 1][dot.y]);
					pq.add(new Dot(dot.x + 2, dot.y, Integer.parseInt(map[dot.x + 2][dot.y])));
				}
			}
			if (dot.y + 2 < map.length) {
				if (dist[dot.x][dot.y + 2] < cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x][dot.y + 2]),
						map[dot.x][dot.y + 1])) {
					dist[dot.x][dot.y + 2] = cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x][dot.y + 2]),
							map[dot.x][dot.y + 1]);
					pq.add(new Dot(dot.x, dot.y + 2, Integer.parseInt(map[dot.x][dot.y + 2])));
				}
			}
			if (dot.x + 1 < map.length && dot.y + 1 < map.length) {
				if (dist[dot.x + 1][dot.y + 1] < cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 1][dot.y + 1]),
						map[dot.x + 1][dot.y])) {
					dist[dot.x + 1][dot.y + 1] = cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 1][dot.y + 1]),
							map[dot.x + 1][dot.y]);
					pq.add(new Dot(dot.x + 1, dot.y + 1, Integer.parseInt(map[dot.x + 1][dot.y + 1])));
				}
				if (dist[dot.x + 1][dot.y + 1] < cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 1][dot.y + 1]),
						map[dot.x][dot.y + 1])) {
					dist[dot.x + 1][dot.y + 1] = cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 1][dot.y + 1]),
							map[dot.x][dot.y + 1]);
					pq.add(new Dot(dot.x + 1, dot.y + 1, Integer.parseInt(map[dot.x + 1][dot.y + 1])));
				}
			}
		}
		System.out.print(dist[dist.length - 1][dist.length - 1]+" ");
		

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = Integer.parseInt(map[0][0]);
		pq = new PriorityQueue<>((a, b) -> a.value - b.value);
		pq.add(new Dot(0, 0, Integer.parseInt(map[0][0])));
		while (!pq.isEmpty()) {
			Dot dot = pq.poll();
			if (dot.x + 2 < map.length) {
				if (dist[dot.x + 2][dot.y] > cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 2][dot.y]),
						map[dot.x + 1][dot.y])) {
					dist[dot.x + 2][dot.y] = +cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 2][dot.y]),
							map[dot.x + 1][dot.y]);
					pq.add(new Dot(dot.x + 2, dot.y, Integer.parseInt(map[dot.x + 2][dot.y])));
				}
			}
			if (dot.y + 2 < map.length) {
				if (dist[dot.x][dot.y + 2] > cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x][dot.y + 2]),
						map[dot.x][dot.y + 1])) {
					dist[dot.x][dot.y + 2] = cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x][dot.y + 2]),
							map[dot.x][dot.y + 1]);
					pq.add(new Dot(dot.x, dot.y + 2, Integer.parseInt(map[dot.x][dot.y + 2])));
				}
			}
			if (dot.x + 1 < map.length && dot.y + 1 < map.length) {
				if (dist[dot.x + 1][dot.y + 1] > cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 1][dot.y + 1]),
						map[dot.x + 1][dot.y])) {
					dist[dot.x + 1][dot.y + 1] = cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 1][dot.y + 1]),
							map[dot.x + 1][dot.y]);
					pq.add(new Dot(dot.x + 1, dot.y + 1, Integer.parseInt(map[dot.x + 1][dot.y + 1])));
				}
				if (dist[dot.x + 1][dot.y + 1] > cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 1][dot.y + 1]),
						map[dot.x][dot.y + 1])) {
					dist[dot.x + 1][dot.y + 1] = cal(dist[dot.x][dot.y], Integer.parseInt(map[dot.x + 1][dot.y + 1]),
							map[dot.x][dot.y + 1]);
					pq.add(new Dot(dot.x + 1, dot.y + 1, Integer.parseInt(map[dot.x + 1][dot.y + 1])));
				}

			}
		}
		System.out.print(dist[dist.length - 1][dist.length - 1]);
	}

	static int cal(int a, int b, String oper) {
		if (oper.equals("+")) {
			return a + b;
		} else if (oper.equals("-")) {
			return a - b;
		} else if (oper.equals("*")) {
			return a * b;
		}
		return 0;
	}

	static class Dot {
		int x;
		int y;
		int value;

		public Dot(int y, int x, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
}
