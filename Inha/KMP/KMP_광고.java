package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KMP_±¤°í {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		String str = st.nextToken();

		int[] next = InitNext(str+"-");
		int maxCombo = next[N];
		System.out.println(N - maxCombo);

	}

	static int[] InitNext(String p) {
		int i, j = 0, M = p.length();
		int[] next = new int[M];
		next[0] = -1;
		for (i = 1, j = 0; i < M; i++, j++) {
			next[i] = j;
			// next[i] = (p.charAt(i) == p.charAt(j)) ? next[j] : j;
			while ((j >= 0) && p.charAt(i) != p.charAt(j))
				j = next[j];
		}

		return next;

	}
}
