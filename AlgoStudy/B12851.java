package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B12851 {
	static boolean finish = false;
	static int result = 0;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int now = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[100001];
		Queue<Integer> q = new LinkedList();
		q.add(now);
		visit[now] = true;
		int cnt = 0;
		if (now == goal) {
			System.out.println("0");
			return;
		}
		while (!q.isEmpty()) {
			if (finish)
				break;
			int temp = q.size();
			cnt++;
			for (int i = 0; i < temp; i++) {
				int nowloc = q.poll();
				if (nowloc + 1 == goal || nowloc - 1 == goal || nowloc * 2 == goal) {
					result = cnt;
					count++;
					finish = true;
				}
				if (nowloc + 1 <= 100000 && !visit[nowloc + 1]) {
					q.add(nowloc + 1);
					// visit[nowloc + 1] = true;
				}
				if (nowloc - 1 >= 0 && !visit[nowloc - 1]) {
					q.add(nowloc - 1);
					// visit[nowloc - 1] = true;
				}
				if (nowloc * 2 <= 100000 && !visit[nowloc * 2]) {
					q.add(nowloc * 2);
					// visit[nowloc * 2] = true;
				}
			}
		}
		System.out.println(result);
		System.out.println(count);
	}

}
