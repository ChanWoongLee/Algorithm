package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14226 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int s = Integer.parseInt(st.nextToken());
		boolean[][] visit = new boolean[s + 1][s + 1];
		visit[1][0] = true;
		Queue<Info> q = new LinkedList<Info>();
		q.add(new Info(1, 0));
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int ss = 0; ss < size; ss++) {
				Info now = q.poll();
				if (now.num == s) {
					System.out.println(time);
					return;
				}
				if (now.num - 1 != 0 && visit[now.num - 1][now.q] == false) {
					visit[now.num - 1][now.q] = true;
					q.add(new Info(now.num - 1, now.q));
				}
				if (now.num + now.q <= s && visit[now.num + now.q][now.q] == false) {
					q.add(new Info(now.num + now.q, now.q));
					visit[now.num + now.q][now.q] = true;
				}

				if (now.num != now.q) {
					q.add(new Info(now.num, now.num));
				}
			}
			for (Info i : q)
				System.out.print(i.num + "," + i.q + " ");
			System.out.println();
			time++;
		}
	}

}

class Info {
	int num, q;

	public Info(int num, int q) {
		this.num = num;
		this.q = q;

	}
}