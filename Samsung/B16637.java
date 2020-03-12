package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B16637 {
	// 10 : 46 시작
	static int N, oper;
	static String[] numar;
	static int result = Integer.MIN_VALUE;
	static boolean[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		numar = new String[N];
		String[] str = bf.readLine().split("");
		for (int i = 0; i < N; i++) {
			numar[i] = str[i];
		}
		if (N == 1) {
			System.out.println(numar[0]);
			return;
		}
		oper = (N - 1) / 2;
		// 5=2최대 2개, 7=3 최대 2개, 9=4 최대3개 10
		// 5,7/2 9,11/3
		// 23/2 45/3
		int maxcnt = (oper / 2) + 1;
		for (int i = 0; i <= maxcnt; i++) {
			temp = new boolean[oper];
			dfs(0, 0, i);
		}
		System.out.println(result);
	}

	static void dfs(int index, int cnt, int maxcnt) {

		if (cnt == maxcnt) {
			int res = oper();
			result = res > result ? res : result;
			return;
		}
		if (index == oper)
			return;
		if (index != 0 && temp[index - 1] == true) {
			temp[index] = false;
			dfs(index + 1, cnt, maxcnt);
			return;
		}

		temp[index] = true;
		dfs(index + 1, cnt + 1, maxcnt);
		temp[index] = false;
		dfs(index + 1, cnt, maxcnt);
	}

	static int oper() {
		LinkedList<String> dq = new LinkedList();
		int operator = 0;
		int res = 0;
		for (int i = 0; i < N; i++) {
			dq.addLast(numar[i]);
			if (numar[i].equals("+") || numar[i].equals("-") || numar[i].equals("*")) {
				if (temp[operator] == true) {
					String oper = dq.removeLast();
					String a = dq.removeLast();
					dq.addLast(String.valueOf(cal(a, oper, numar[i + 1])));
					i++;
				}
				operator++;
			}
		}
		while (!(dq.size() == 1))
			dq.addFirst(String.valueOf(cal(dq.removeFirst(), dq.removeFirst(), dq.removeFirst())));
		return Integer.parseInt(dq.removeFirst());
	}

	static int cal(String a, String oper, String b) {
		int ret = 0;
		if (oper.equals("+")) {
			ret = Integer.parseInt(a) + Integer.parseInt(b);
		} else if (oper.equals("-")) {
			ret = Integer.parseInt(a) - Integer.parseInt(b);
		} else if (oper.equals("*")) {
			ret = Integer.parseInt(a) * Integer.parseInt(b);
		}
		return ret;
	}
}
