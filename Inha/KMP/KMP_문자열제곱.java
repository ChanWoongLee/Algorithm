package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KMP_문자열제곱 {

	public static void main(String[] args) throws IOException {
//			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		while (true) {
//			String str = bf.readLine();
//			if (str.equals("."))
//				break;
//
//			int[] next = getPi(str);
//			if (next[str.length() - 1] == 0 || next[str.length() - 1] % (str.length() - next[str.length() - 1]) == 1)
//				System.out.println("1");
//			else
//				System.out.println(str.length() / (str.length() - next[str.length() - 1]));
//		}

		 String str = "aabba";
		 int[] next = getPi(str);
		 // -1 일때  접두사 == 접미사 인 앞부분 부터  같은부분의  idx
		 // 0 일떄 접두사 == 접미사 인 앞부분부터 같은 부분의 idx+1
		 for (int i : next)
		 System.out.print(i + " ");
		 System.out.println();
//		 String pa = "ea";
//		 System.out.println(kmp(str, pa, next));
//		
//		 next = initnext(str);
//		 for (int i : next)
//		 System.out.print(i + " ");
//		 System.out.println();
//		 System.out.println(KMP(str, pa, next));
	}

	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j - 1];
			if (pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}

	static int kmp(String t, String p, int[] pi) {
		int j = 0, len_p = p.length(), len_t = t.length();
		int i = 0;
		for (i = 0; i < len_t && j < len_p; i++) {
			while (t.charAt(i) != p.charAt(j) && j > 0)
				j = pi[j - 1];
			if(t.charAt(i) == p.charAt(j))
				j++;
		}
		if (j == len_p)
			return i - len_p;
		return i;
	}

	static int[] initnext(String pattern) {
		int[] next = new int[pattern.length()];
		next[0] = -1;
		int j = 0;
		for (int i = 1; i < pattern.length(); i++, j++) {
			next[i] = j;
			while (j >= 0 && pattern.charAt(j) != pattern.charAt(i))
				j = next[j];
		}
		return next;
	}

	static int KMP(String st, String pattern, int[] next) {
		int i, j;
		int cnt = 0;
		for (i = 0, j = 0; i < st.length() && j < pattern.length(); i++, j++) {
			if (st.charAt(i) != pattern.charAt(j)) {
				j = next[j];
			}
		}
		if (j == pattern.length())
			return i - pattern.length();
		return i;

	}
}
