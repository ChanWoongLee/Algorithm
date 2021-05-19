package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20040 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		parent = new int[n];
		for(int i = 0; i < parent.length; i++)
			parent[i] = i;
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int startP = findParent(start);
			int endP = findParent(end);
			if (startP == endP) {
				System.out.println(i + 1);
				return;
			} else {
				union(startP, endP);
			}

		}
		System.out.println(0);
	}

	static int findParent(int a) {
		if (parent[a] == a)
			return parent[a];
		else {
			return parent[a] = findParent(parent[a]);
		}
	}

	static void union(int a, int b) {
		int aP = findParent(a);
		int bP = findParent(b);
		parent[aP] = bP;
	}

	static class line {
		int start, end;

		public line(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

	}
}
