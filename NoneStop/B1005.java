package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1005 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int t = Integer.parseInt(st.nextToken());
		while (t-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] money = new int[N + 1];
			int[] inBound = new int[N + 1];
			int[] nowMoney = new int[N + 1];
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i <= N; i++) {
				money[i] = Integer.parseInt(st.nextToken());
				nowMoney[i] = money[i];
			}
			ArrayList<Integer>[] graph = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start].add(end);
				inBound[end]++;
			}
			st = new StringTokenizer(bf.readLine());
			int dest = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 1; i <= N; i++) {
				if (inBound[i] == 0) {
					q.add(i);
				}
			}
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int i : graph[now]) {
					inBound[i]--;
					nowMoney[i] = Math.max(nowMoney[i], nowMoney[now] + money[i]);
					if (inBound[i] == 0) {
						q.add(i);
					}
				}
			}
			System.out.println(nowMoney[dest]);
		}
	}
}
