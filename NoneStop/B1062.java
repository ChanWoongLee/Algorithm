package NoneStop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1062 {
	static String[] words;
	static boolean[] visit;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 5;
		if (K < 0) {
			System.out.println("0");
			return;
		}
		visit = new boolean[26];
		words = new String[N];
		visit['a' - 'a'] = true;
		visit['n' - 'a'] = true;
		visit['t' - 'a'] = true;
		visit['i' - 'a'] = true;
		visit['c' - 'a'] = true;
		for (int i = 0; i < N; i++) {
			words[i] = bf.readLine().replace("[antic]", "");
		}
		recur(0, K);
		System.out.println(ans);

	}

	static void recur(int cnt, int max) {
		if (cnt == max) {
			int num = 0;
			for (String w : words) {
				int i = 0;
				for (i = 0; i < w.length(); i++) {
					if (!visit[w.charAt(i) - 'a'])
						break;
				}
				if (i == w.length())
					num++;
			}

			ans = ans > num ? ans : num;
			return;
		}
		for (int i = cnt; i < 26; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			recur(cnt + 1, max);
			visit[i] = false;
		}
	}

}
