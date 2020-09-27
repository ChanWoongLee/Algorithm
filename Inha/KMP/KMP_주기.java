package Inha;

public class KMP_аж╠Б {

	public static void main(String[] args) {

	}

	static int[] initNext(String pattern) {
		int[] next = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
				j = next[j - 1];
			if (pattern.charAt(i) == pattern.charAt(j)) {
				next[i] = ++j;
			}
		}
		return next;
	}
}
