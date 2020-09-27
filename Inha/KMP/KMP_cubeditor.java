package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KMP_cubeditor {
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		for (int i = 0; i < str.length(); i++) {
			getPi(str.substring(i, str.length()));
		}
		System.out.println(max);
	}

	static void getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
				max = Integer.max(max, j);
			}
		}
	}

}
