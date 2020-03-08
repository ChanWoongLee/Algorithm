package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class B1753 {
	static int V; // 정점의 개수
	static int E; // 간선의 개수
	static int START_V; // 시작 정점의 번호
	static int[] dist; // 시작점 부터의 거리
	static boolean[] visited; // 방문여부 체크
	static ArrayList<Edge>[] list;// arraylist 배열 정점간 정보

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] sar = bf.readLine().split(" ");
		V = Integer.parseInt(sar[0]);
		E = Integer.parseInt(sar[1]);
		sar = bf.readLine().split(" ");
		START_V = Integer.parseInt(sar[0]);

		visited = new boolean[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList();
		}
		for (int i = 0; i < E; i++) {
			sar = bf.readLine().split(" ");
			list[Integer.parseInt(sar[0])].add(new Edge(Integer.parseInt(sar[1]), Integer.parseInt(sar[2])));
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue();
		pq.add(START_V);
		dist[START_V] = 0;
		while (!pq.isEmpty()) {
			int current = pq.poll();
			visited[current] = true;
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i).end;
				int value = list[current].get(i).value;
				if(dist[next] > dist[current]+value) {
					dist[next] = Math.min(dist[next], value+dist[current]);
					pq.add(next);
				}
			}
		}
		for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
	}
}

class Edge {
	int end;
	int value;

	public Edge(int end, int value) {
		this.end = end;
		this.value = value;
	}
	 public int compareTo(Edge o) {
	        // TODO Auto-generated method stub
	        if(this.value>o.value) return 1;
	        else if(this.value==o.value) return 0;
	        else return -1;
	    }
}