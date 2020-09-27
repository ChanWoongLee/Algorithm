package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP_ã��2 {
	static int cnt = 0;
	static StringBuilder stb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String pattern = bf.readLine();
		int[] next = initNext(pattern);
		KMP(str, pattern, initNext(pattern));
		System.out.println(cnt);
		System.out.println(stb);
	}

	// -1 �϶� ���λ� == ���̻� �� �պκ� ���� �����κ��� idx / i-1 ���� prefix , subfix ��ġ ����
	// 0 �ϋ� ���λ� == ���̻� �� �պκк��� ���� �κ��� idx+1 / i ������ prefix, sufix ��ġ ����

	static int[] initNext(String pattern) {
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

	static void KMP(String t, String p, int[] next) {
		int j = 0, plen = p.length(), tlen = t.length();
		int i = 0;

		for (i = 0; i < tlen && j < plen; i++) {
			while (t.charAt(i) != p.charAt(j) && j > 0)
				j = next[j - 1];
			if (t.charAt(i) == p.charAt(j)) {
				if (j == plen - 1) {
					stb.append(i - plen + 2).append(" ");
					j = next[j];
					cnt++;
				} else
					j++;
			}
		}

		// if (j == plen)
		// return i - plen;
		// return i;
	}

}
