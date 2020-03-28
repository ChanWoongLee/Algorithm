package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2529 {
	// 12 43Ω√¿€
	static int N;
	static int[] temp;
	static boolean[] visit;
	static String[] oper;
	static Queue<String> q = new LinkedList();
	static boolean finish;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		temp = new int[N + 1];
		visit = new boolean[10];
		oper = bf.readLine().split(" ");
		int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] num2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		finish = false;
		dfs(0, num);
		finish = false;
		dfs(0, num2);
		System.out.println(q.poll());
		System.out.println(q.poll());
	}

	static boolean check(int a, int b, int index) {
		String o = oper[index];
		if (o.equals(">")) {
			if (a > b)
				return true;
			else
				return false;
		} else {
			if (a < b)
				return true;
			else
				return false;
		}
	}

	static void dfs(int cnt, int[] n) {
		if (finish)
			return;
		if (cnt == N + 1) {
			for (int i = 0; i < N; i++) {
				if (!check(temp[i], temp[i + 1], i))
					return;
			}
			String str = "";
			for (int s : temp) {
				str += String.valueOf(s);
			}
			q.add(str);
			finish = true;
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (visit[i] == false) {
				temp[cnt] = n[i];
				visit[i] = true;
				dfs(cnt + 1, n);
				visit[i] = false;
			}
		}
	}
}
