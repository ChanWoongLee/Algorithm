package Samsung2020_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15591 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] ar = new ArrayList[n+1];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			String[] str = bf.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			int value = Integer.parseInt(str[2]);
			ar[start].add(new Node(end, value));
			ar[end].add(new Node(start, value));
		}
		for (int i = 0; i < q; i++) {
			String[] str = bf.readLine().split(" ");
			int k = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
			int result = 0;
			Queue<Node> qu = new LinkedList<Node>();
			qu.add(new Node(v, Integer.MAX_VALUE));
			boolean[] visit = new boolean[n+1];
			visit[v] = true;
			while (!qu.isEmpty()) {
				Node nowNode = qu.poll();
				int USADO = 0;
				for (Node node : ar[nowNode.end]) {
					if(visit[node.end])
						continue;
					USADO = Math.min(node.value, nowNode.value);
					if (USADO >= k) {
						result++;
						qu.add(new Node(node.end, USADO));
						visit[node.end] = true;
					}
				}
			}
			System.out.println(result);
		}
	}

	static class Node {
		int end, value;

		public Node(int end, int value) {
			super();
			this.end = end;
			this.value = value;
		}

	}
}
