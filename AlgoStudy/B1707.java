package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1707 {
	static int[] visit; // {0 : 방문안함 , 1: red, 2: black}
	static ArrayList<Integer>[] graph;
	static Queue<Integer> pqueue;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		while (testCase-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			visit = new int[N + 1];
			int M = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N + 1];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start].add(end);
				graph[end].add(start);
			} // arraylist 형식의 그래프 완성이다
			boolean yes = true;
			for (int start = 1; start <= N; start++) {
				pqueue = new LinkedList();
				if(visit[start] != 0)
					continue;
				pqueue.add(start);
				visit[start] = 1;
				yes = true;
				while (!pqueue.isEmpty()) {
					int node = pqueue.poll();
					int nowColor = visit[node];
					for (int i = 0; i < graph[node].size(); i++) {
						int friend = graph[node].get(i);
						if (visit[friend] == nowColor) {
							System.out.print("NO");
							yes = false;
							start = N+1;
							graph[node].clear();
							pqueue.clear();
						}
					}
					for (int i = 0; i < graph[node].size(); i++) {
						int friend = graph[node].get(i);
						if (visit[friend] == 0) {
							pqueue.add(friend);
							visit[friend] = nowColor == 1 ? 2 : 1;
						}
					}
				}
			}
			if (yes) {
				System.out.print("YES");
			}
		}
	}
}
