package SWexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1247 {
	static int result;
	static loc[] num;
	static boolean[] visit;
	static int[] temp;
	static loc office;
	static loc home;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());// N

		for (int test_case = 1; test_case <= T; test_case++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(bf.readLine());
			int size = Integer.parseInt(st.nextToken());// N
			num = new loc[size];
			visit = new boolean[size];
			temp = new int[size];
			st = new StringTokenizer(bf.readLine());
			office = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < num.length; i++) {
				num[i] = new loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for (int k = 0; k < temp.length; k++) {
				visit[k] = true;
				dfs(k, 0);
				visit[k] = false;
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

	static void dfs(int index, int cnt) {
		temp[cnt] = index;
		if (cnt == num.length - 1) {
			int res = 0;
			res += Math.abs(num[temp[0]].r - office.r) + Math.abs(num[temp[0]].c - office.c);
			res += Math.abs(num[temp[num.length - 1]].r - home.r) + Math.abs(num[temp[num.length - 1]].c - home.c);
			for (int i = 0; i < num.length - 1; i++) {
				res += Math.abs(num[temp[i]].r - num[temp[i + 1]].r) + Math.abs(num[temp[i]].c - num[temp[i + 1]].c);
			}
			result = result > res ? res : result;
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				dfs(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

}

class loc {
	int r;
	int c;

	public loc(int rr, int cc) {
		r = rr;
		c = cc;
	}
}