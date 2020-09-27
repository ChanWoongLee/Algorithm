package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KMP_Ã£±â {
	static ArrayList<Integer> ar = new ArrayList();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String pattern = bf.readLine() + " ";
		int[] next = initNext(pattern);
		int cnt = (KMP(str, pattern, initNext(pattern)));
		System.out.println(cnt);
		for (int i : ar) {
			System.out.print(i + " ");
		}
	}

	static int KMP(String st, String pattern, int[] next) {
		int i, j;
		int cnt = 0;
		for (i = 0, j = 0; i < st.length() && j < pattern.length() - 1; i++, j++) {
			while (j >= 0 && (st.charAt(i) != pattern.charAt(j))) {
				j = next[j];
			}
			if (j == pattern.length() - 2) { 
				ar.add(i - j + 1);
				cnt++;
				j = next[j + 1];
				j--;
			}
		}

		return cnt;
	}

	static int[] initNext(String pattern) {
		int next[] = new int[pattern.length()];
		next[0] = -1;
		int j = 0;
		for (int i = 1; i < pattern.length(); i++, j++) {
			next[i] = j;
			while (j >= 0 && (pattern.charAt(i) != pattern.charAt(j)))
				j = next[j];
		}

		return next;
	}
}
