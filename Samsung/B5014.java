package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5014 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int total = Integer.parseInt(st.nextToken());
		int now = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[total + 1];
		// 올라가서 내려옴 != 내려가서 올라옴 -> 따로 해야됨
		Queue<info> q = new LinkedList();
		q.add(new info(now, up));
		q.add(new info(now, -down));
		visit[now] = true;
		int cnt = 0;
		if (now == goal) {
			System.out.println("0");
			return;
		}

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				info temp = q.poll();
				int move = temp.nextMov;
				int nowloc = temp.nowloc;
				if (nowloc + move > total || nowloc + move < 1) // 아래위층 뚫으면 할필요없음
					continue;
				if (nowloc + move == goal) {
					System.out.println(cnt);
					return;
				}
				if (visit[nowloc + move] == true)
					continue;

				q.add(new info(nowloc + move, up));
				q.add(new info(nowloc + move, -down));
				visit[nowloc + move] = true;
			}
		}
		System.out.println("use the stairs");
	}
}

class info {
	int nowloc;
	int nextMov;

	public info(int nowloc, int nextMov) {
		this.nextMov = nextMov;
		this.nowloc = nowloc;
	}
}
