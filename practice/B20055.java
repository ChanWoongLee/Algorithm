package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B20055 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ar = new ArrayList<>();
		ArrayList<Integer> visit = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < 2 * n; i++) {
			ar.add(Integer.parseInt(st.nextToken()));
			visit.add(0);
		}
		ArrayList<Integer> robot = new ArrayList<>();
		int zerocnt = 0;.
		int answer = 1;

		while (zerocnt < k) {
			ar.add(0, ar.remove(ar.size() - 1));
			visit.add(0, visit.remove(visit.size() - 1));
			for (int i = 0; i < robot.size(); i++) {
				int now = robot.get(i);
				if (now + 1 >= 2 * n)
					robot.set(i, 0);
				else
					robot.set(i, now + 1);
			}
			// 컨베이어 이동

			for (int i = 0; i < robot.size(); i++) {
				int now = robot.get(i);
				int next;
				if (now + 1 >= 2 * n)
					next = 0;
				else
					next = now + 1;
				if (visit.get(next) == 0 && ar.get(next) > 0) {
					if (ar.get(next) - 1 == 0)
						zerocnt++;
					ar.set(next, ar.get(next) - 1);
					visit.set(now, 0);
					visit.set(next, 1);
					robot.set(i, next);
				}
			}
			// 로봇 이동

			if (visit.get(0) == 0) {
				ar.set(0, ar.get(0) - 1);
				visit.set(0, 1);
				robot.add(0);
				if (ar.get(0) == 0)
					zerocnt++;
			}
			// 놓기

			answer++;
		}
		System.out.println(answer);
	}

}
