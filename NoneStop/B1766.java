package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1766 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] inbound = new int[n + 1];
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			inbound[end]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (inbound[i] == 0)
				pq.add(i);
		}
		while (!pq.isEmpty()) {
			int now = pq.poll();
			System.out.print(now + " ");
			for (int i : graph[now]) {
				inbound[i]--;
				if (inbound[i] == 0)
					pq.add(i);
			}
		}
	}

}
