package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KMP_AAAA {

	public static void main(String[] args) throws IOException {
		String text = "AAAAA";
		String pattern = "AA";
		int pos, previous = 0, i = 0;
		int N = text.length();
		int M = pattern.length();
		while (true) {
			pos = KMP(pattern, text.substring(i, N));
			pos += previous;
			i = pos + 1;
			if (i <= N)
				System.out.println("패턴이 발생한 위치 : " + pos);
			else
				break;
			previous = i;
		}

	}

	static int[] InitNext(String p) {
		int i, j = 0, M = p.length();
		int[] next = new int[M];
		next[0] = -1;
		for (i = 1, j = 0; i < M; i++, j++) {
			// next[i] =j;
			next[i] = (p.charAt(i) == p.charAt(j)) ? next[j] : j;
			while ((j >= 0) && p.charAt(i) != p.charAt(j))
				j = next[j];
		}

		return next;

	}

	static int KMP(String p, String t) {// KMP
		int i, j, M = p.length(), N = t.length();
		int next[] = InitNext(p);
		for (i = 0, j = 0; j < M && i < N; i++, j++)
			while ((j >= 0) && (t.charAt(i) != p.charAt(j)))
				j = next[j];
		if (j == M)
			return i - M;
		else {
			return i;
		}
	}
}