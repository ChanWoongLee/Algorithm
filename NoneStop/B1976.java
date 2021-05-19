package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1976 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> travel = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			travel.add(Integer.parseInt(st.nextToken()) - 1);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(travel.remove(0));
		boolean[] visit = new boolean[n];
		visit[q.peek()] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < n; i++) {
				if (graph[now][i] == 1 && visit[i] == false) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
		for(int i : travel) {
			if(visit[i] == false) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
