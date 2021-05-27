package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3780 {
	static int[] parent;
	static int[][] graph;
	static int N;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		while (t-- > 0) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()) + 1;
			parent = new int[N];
			dist = new int[N];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
			while (true) {
				st = new StringTokenizer(bf.readLine());
				String action = st.nextToken();
				if (action.equals("E")) {
					int node = Integer.parseInt(st.nextToken());
					find(node);
					System.out.println(dist[node]);
				} else if (action.equals("I")) {
					int office = Integer.parseInt(st.nextToken());
					int center = Integer.parseInt(st.nextToken());
					union(office, center);
				} else {
					return;
				}
			}
		}
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			int temp = find(parent[a]);
			dist[a] += dist[parent[a]];
			return parent[a] = temp;
		}
	}

	static void union(int a, int b) {
		parent[a] = b;
		dist[a] = Math.abs(a - b) % 1000;
	}
}
