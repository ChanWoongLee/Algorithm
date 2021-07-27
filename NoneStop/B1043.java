package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1043 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> known = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < k; i++) {
			known.add(Integer.parseInt(st.nextToken()));
		}
		ArrayList<Integer>[] graph = new ArrayList[m];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			k = Integer.parseInt(st.nextToken());
			int[] temp = new int[k];
			for (int j = 0; j < k; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
				graph[i].add(temp[j]);
			}
			for (int j = 0; j < k - 1; j++) {
				int start = temp[j];
				int end = temp[j + 1];
				union(start, end);
			}
		}
		for (int i = 1; i < parent.length; i++) {
			find(i);
		}
		ArrayList<Integer> disable = new ArrayList<>();
		int ans = 0;
		for (int i = 1; i < parent.length; i++) {
			if (known.contains(i)) {
				disable.add(parent[i]);
			}
		}
		for (ArrayList<Integer> ar : graph) {
			boolean check = true;
			for (int val : ar) {
				if (disable.contains(parent[val])) {
					check = false;
					break;
				}

			}
			if (check)
				ans++;
		}
		System.out.println(ans);

	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		parent[a] = b;
	}
}
