package LeetCode;

import java.util.ArrayList;

public class L34 {

	public static void main(String[] args) {

	}

	public List<Integer> findAnagrams(String s, String p) {
		int[] save = new int[s.length() - p.length()];
		for (int i = 0; i < s.length() - p.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				save[i] += s.charAt(i + j) + 'a';
			}
		}
		int toFind = 0;
		for (int i = 0; i < p.length(); i++) {
			toFind += p.charAt(i) - 'a';
		}
		ArrayList<Integer> ar = new ArrayList<>();
		for (int i = 0; i < save.length; i++) {
			if (save[i] == toFind)
				ar.add(i);
		}
		return ar;
	}
}
