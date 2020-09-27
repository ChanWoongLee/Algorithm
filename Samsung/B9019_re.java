package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9019_re {
	static int result;
	static String start, end;
	static boolean flag;
	static ArrayList<Integer> ar;
	static String[] str = { "D", "S", "L", "R" };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int test = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Queue<mistake> q = new LinkedList<mistake>();
			boolean[] visit = new boolean[10000];
			q.add(new mistake(start, ""));
			while (!q.isEmpty()) {
				mistake now = q.poll();
				if (now.num == end) {
					System.out.println(now.str);
					break;
				}

				int D = now.num * 2;
				if (D > 9999)
					D %= 10000;
				if (!visit[D]) {
					q.add(new mistake(D, now.str + "D"));
					visit[D] = true;
				}
				int S = now.num - 1;
				if (S <= 0)
					S = 9999;
				if (!visit[S]) {
					q.add(new mistake(S, now.str + "S"));
					visit[S] = true;
				}
				int L = ((now.num % 1000) * 10) + (now.num / 1000);
				if (!visit[L]) {
					q.add(new mistake(L, now.str + "L"));
					visit[L] = true;
				}
				int R = ((now.num % 10) * 1000) + (now.num / 10);
				if (!visit[R]) {
					q.add(new mistake(R, now.str + "R"));
					visit[R] = true;
				}
				if (D == 0 || S == 0 || R == 0 || L == 0)
					System.out.println("Fefefe");
			}
		}
	}
}

class mistake {
	int num;
	String str;

	public mistake(int num, String str) {
		this.num = num;
		this.str = str;
	}
}