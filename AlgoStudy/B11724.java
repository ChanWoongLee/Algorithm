package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11724 {
	static boolean[] visit; // {0 : 방문안함 , 1: red, 2: black}
	static ArrayList<Integer>[] graph;
	static Queue<Integer> pqueue;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		visit = new boolean[N + 1];
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		} // arraylist 형식의 그래프 완성이다

		pqueue = new LinkedList();
		int count = 0;
		for (int num = 1; num <= N; num++) {
			if (visit[num] == false) {
				count++;
				pqueue.add(num);
				while (!pqueue.isEmpty()) {
					int node = pqueue.poll();
					for (int i = 0; i < graph[node].size(); i++) {
						int friend = graph[node].get(i);
						if (visit[friend] == false) {
							pqueue.add(friend);
							visit[friend] = true;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
