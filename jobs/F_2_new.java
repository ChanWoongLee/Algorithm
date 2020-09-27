package jobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class F_2_new {
	static boolean[] visit;
	static ArrayList<Integer>[] student;
	static ArrayList<Integer> temp;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int studentAmount = Integer.parseInt(st.nextToken());
		int select = Integer.parseInt(st.nextToken());
		int connect = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		temp = new ArrayList();
		visit = new boolean[31];
		for (int i = 0; i < select; i++) {
			temp.add(st.nextToken().charAt(0) - 'A');
		}
		student = new ArrayList[studentAmount];
		for (int i = 0; i < student.length; i++) {
			student[i] = new ArrayList();
		}
		for (int i = 0; i < connect; i++) {
			st = new StringTokenizer(bf.readLine());
			int me = st.nextToken().charAt(0) - 'A';
			int friend = st.nextToken().charAt(0) - 'A';
			student[me].add(friend);
			student[friend].add(me);
		}

		dfs(temp.get(0));
		if (cnt == select) {
			System.out.println("1");
			return;
		} else {
			System.out.println("0");
			return;
		}
	}

	static void dfs(int num) {
		visit[num] = true;
		cnt++;
		for (int i = 0; i < student[num].size(); i++) {
			int target = student[num].get(i);
			if (visit[target] || temp.contains(target) == false)
				continue;
			dfs(target);
		}
	}
}
