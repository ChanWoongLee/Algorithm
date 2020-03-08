package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10974 {
	static int[] map;
	static boolean[] visit;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N];
		temp = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			map[i] = i + 1;
		}
		for (int i = 0; i < N; i++) {
			visit[i] = true;
			dfs(i, 0);
			visit[i] = false;
		}
	}

	static void dfs(int n, int d) {
		temp[d] = n+1;
		if (d == map.length - 1) {
			for (int i = 0; i <= d; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < map.length; i++) {
			if(visit[i] == true)
				continue;
			visit[i] = true;
			dfs(i,d+1);
			visit[i] = false;
		}

	}

}
