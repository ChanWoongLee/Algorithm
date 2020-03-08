package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1260 {
	// bfs 는 Queue 로 DFS는 재귀로
	static boolean[] visit;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> pqueue;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		visit = new boolean[N + 1];
		int M = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
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
		
		for (int i = 0; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}// 낮은 노드 방문을 위해 오름차순 배열
		
		visit[startNode] = true;
		System.out.print(startNode+" ");
		dfs(startNode);
		System.out.println();

		
		visit = new boolean[N + 1];
		pqueue = new LinkedList();
		pqueue.add(startNode);
		visit[startNode] = true;
		while (!pqueue.isEmpty()) {
			int node = pqueue.poll();
			System.out.print(node + " ");
			for (int i = 0; i < graph[node].size(); i++) {
				int friend = graph[node].get(i);
				if (visit[friend] == false) {
					pqueue.add(friend);
					visit[friend] = true;
				}
			}
		}
	}

	static void dfs(int startNode) {
		for (int i = 0; i < graph[startNode].size(); i++) {
			int friend = graph[startNode].get(i);
			if (visit[friend] == false) {
				visit[friend] = true;
				System.out.print(friend + " ");
				dfs(friend);
			} 	
		}
	}
}
