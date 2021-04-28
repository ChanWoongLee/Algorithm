package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] degree = new int[N + 1];
		ArrayList<Integer>[] ar = new ArrayList[N + 1];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ar[start].add(end);
			degree[end]++;
		}
		Queue<Integer> first = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				first.add(i);
			}
		}
		while (!first.isEmpty()) {
			int now = first.poll();
			System.out.print(now + " ");
			for (int i = 0; i < ar[now].size(); i++) {
				int friend = ar[now].get(i);
				degree[friend]--;
				if (degree[friend] == 0)
					first.add(friend);
			}
		}

	}

}
