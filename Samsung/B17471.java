package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17471 {
	static ArrayList<Integer>[] place;
	static boolean[] visit;
	static int[] value;
	static int total = 0;
	static int result = Integer.MAX_VALUE;
	// ������ ����� ���ϱ�
	// ������ ������ ���⿡ �������̾�

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		place = new ArrayList[N + 1];
		value = new int[N + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i < N + 1; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			total += value[i];
		}
		for (int i = 0; i < place.length; i++) {
			place[i] = new ArrayList();
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int connect = Integer.parseInt(st.nextToken());
				place[i].add(connect);
			}
		}
		visit = new boolean[N + 1];
		int cnt = 0;
		Queue<Integer> q = new LinkedList();
		boolean onetime = true;
		int sum = 0;
		for (int i = 1; i < N + 1; i++) {
			if (cnt == 3)
				break;
			if (visit[i] == false) {
				cnt++;
				q.add(i);
				visit[i] = true;
				while (!q.isEmpty()) {
					int now = q.poll();
					if (onetime)
						sum += value[now];
					for (int j = 0; j < place[now].size(); j++) {
						if (visit[place[now].get(j)] == false) {
							q.add(place[now].get(j));
							visit[place[now].get(j)] = true;
						}
					}
				}
			}
			onetime = false;
		} // �׷��� �Ǻ�

		if (cnt == 3)// ���ű��� 2���� ���� �� ������
			System.out.println("-1");
		else if (cnt == 2) {// ���ű��� 2���� ���������ϴµ� ������ �ȵǾ� �Ѱ��� ������ιۿ� ������ �ۿ�������
			System.out.println(Math.abs(total - 2 * sum));
		} else {// ��缱�ű��� ���� ������Ǽ��� �� ����.
			visit = new boolean[N + 1];
			dfs(1);
			System.out.println(result);
		}

	}

	static void dfs(int index) {
		if (index >= place.length) {
			checkConnect();
			return;
		}

		visit[index] = true;
		dfs(index + 1);
		visit[index] = false;
		dfs(index + 1);
	}

	static void checkConnect() {
		int sum = 0;
		int team1 = 0; // true �� ��
		int team2 = 0;// false �� ��
		for (int i = 1; i < visit.length; i++) {
			if (visit[i] == true) {
				sum += value[i];
				team1 = i;
			} else
				team2 = i;
		}
		if (team1 == 0 || team2 == 0)
			return;
		int[] check = new int[visit.length];
		dfs(team1, true, check);
		dfs(team2, false, check);

		for(int i = 1; i < check.length; i++) {
			if(check[i] == 0)
				return;
		}
		
		result = result > Math.abs(total - 2 * sum) ? Math.abs(total - 2 * sum) : result;
	}

	static void dfs(int team, boolean v, int[] check) {
		check[team] = 1;
		for (int t : place[team]) {
			if (visit[t] == v && check[t] != 1) {
				dfs(t, v, check);
			}
		}
	}
}
