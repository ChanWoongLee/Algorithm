package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KMP_시계사진들 {
	static int[] text = new int[720000];
	static int[] pattern = new int[360000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer t = new StringTokenizer(bf.readLine());
		StringTokenizer p = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			int tt = Integer.parseInt(t.nextToken());
			text[tt] = 1;
			text[tt + 360000] = 1;
			pattern[Integer.parseInt(p.nextToken())] = 1;
		}
		if (KMP(text, pattern, initNext(pattern)))
			System.out.println("possible");
		else
			System.out.println("impossible");
	}

	static int[] initNext(int[] pattern2) {
		int[] next = new int[pattern2.length];

		for (int i = 1, j = 0; i < pattern2.length; i++) {
			while (j > 0 && (pattern2[i] != pattern2[j]))
				j = next[j - 1];
			if (pattern2[i] == pattern2[j])
				next[i] = ++j;
		}
		return next;
	}

	static boolean KMP(int[] text2, int[] pattern2, int[] next) {
		int i, j, tlen = text2.length, plen = pattern2.length;
		for (i = 0, j = 0; i < tlen; i++) {
			while (j > 0 && text2[i] != pattern2[j])
				j = next[j - 1];
			if (text2[i] == pattern2[j]) {
				if (j == plen - 1)
					return true;
				else
					j++;
			}
		}
		return false;
	}
}
