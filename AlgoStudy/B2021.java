package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2021 {
	static ArrayList<info>[] node;
	static int start;
	static int end;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int train = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());
		int[] transfer = new int[train + 1];
		boolean[] visit = new boolean[train + 1];
		node = new ArrayList[train + 1];
		for (int i = 0; i < node.length; i++) {
			node[i] = new ArrayList();
		}
		for (int i = 0; i < line; i++) {
			String[] str = bf.readLine().split(" ");
			for (int j = 0; j < str.length - 2; j++) {
				transfer[Integer.parseInt(str[j])]++;
				node[Integer.parseInt(str[j])].add(new info(Integer.parseInt(str[j + 1]), 0));
				node[Integer.parseInt(str[j + 1])].add(new info(Integer.parseInt(str[j]), 0));
			}
			transfer[Integer.parseInt(str[str.length - 2])]++;
		}
		ArrayList<Integer> t = new ArrayList();
		for (int i = 1; i < transfer.length; i++) {
			if (transfer[i] >= 2)
				t.add(i);
		}
		st = new StringTokenizer(bf.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int result = 0;
		Queue<info> q = new LinkedList();
		q.add(new info(start, 0));
		visit[start] = true;
		while (!q.isEmpty()) {
			info now = q.poll();
			int nownum = now.num;
			int cnt = now.cnt;
			for (int i = 0; i < node[nownum].size(); i++) {
				if (node[nownum].get(i).num == end) {
					System.out.println(cnt);
					System.exit(0);
				}
				if (visit[node[nownum].get(i).num] == false) {
					visit[node[nownum].get(i).num] = true;
					if (t.contains(node[nownum].get(i).num) == true)
						q.add(new info(node[nownum].get(i).num, cnt + node[nownum].get(i).cnt + 1));
					else {
						int n = node[nownum].get(i).num;
						while (!t.contains(n)) {
							int index = 0;
							if (visit[node[n].get(index).num])
								index = 1;
							else
								index = 0;
							visit[n] = true;
							n = node[n].get(index).num;
						}
						if (n == end) {
							System.out.println(cnt);
							System.exit(0);
						}
						q.add(new info(n, cnt + node[nownum].get(i).cnt + 1));
					}
				}
			}
		}
		System.out.println(-1);
	}
}

class info {
	int num;
	int cnt;

	public info(int n, int c) {
		num = n;
		cnt = c;
	}
}
