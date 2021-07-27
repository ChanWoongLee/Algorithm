package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1068 {
	static int[][] graph; // graph[a][b] -> a¿¡¼­ b·Î
	static boolean[] visit;
	static int N;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);

		graph = new int[N][N];
		visit = new boolean[N];
		Queue<Integer> q = new LinkedList();
		str = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			if (!str[i].equals("-1")) {
				int parent = Integer.parseInt(str[i]);
				graph[parent][i] = 1;
			}
		}

		String[] str2 = bf.readLine().split(" ");
		int removeNode = Integer.parseInt(str2[0]);

		for (int i = 0; i < N; i++) {
			remove(removeNode);
			visit[removeNode] = true;
		}

		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(str[i]) == -1 && visit[i] == false) {
				dfs(i);
			}
		}

		System.out.println(result);
	}

	static void remove(int n) {
		for (int i = 0; i < N; i++) {
			if (graph[n][i] == 1 && visit[i] == false) {
				visit[i] = true;
				dfs(i);
			}
		}
	}

	static void dfs(int n) {
		boolean haveChild = false;
		for (int i = 0; i < N; i++) {
			if (graph[n][i] == 1 && visit[i] == false) {
				visit[i] = true;
				haveChild = true;
				dfs(i);
			}
		}

		if (!haveChild) {
			result++;
		}
	}

}
