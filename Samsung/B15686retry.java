package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686retry { // 치킨 배달
	static int[][] map;
	static ArrayList<loc> person;
	static ArrayList<loc> store;
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		person = new ArrayList();
		store = new ArrayList();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					store.add(new loc(i, j));
				if (map[i][j] == 1)
					person.add(new loc(i, j));
			}
		}
		visit = new boolean[store.size()];
		dfs(0, 1, M);
		System.out.println(result);
	}

	static void dfs(int n, int d, int M) {

		if (d == M + 1) {
			int comp = 0;
			for (int i = 0; i < person.size(); i++) {
				loc home = person.get(i);
				int distance = Integer.MAX_VALUE;
				for (int j = 0; j < visit.length; j++) {
					if (visit[j] == true) {
						loc chiken = store.get(j);
						int dis = Math.abs(home.r - chiken.r) + Math.abs(home.c - chiken.c);
						distance = distance < dis ? distance : dis;
					}
				}
				comp += distance;
			}
			result = result > comp ? comp : result;
			return;
		}
		if (n == store.size())
			return;
		visit[n] = true;
		dfs(n + 1, d + 1, M);
		visit[n] = false;
		dfs(n + 1, d, M);
	}
}

//class loc {
//	int r, c;
//
//	loc(int x, int y) {
//		r = x;
//		c = y;
//	}
//}
