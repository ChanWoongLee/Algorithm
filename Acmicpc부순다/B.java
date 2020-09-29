package AcmicpcºÎ¼ø´Ù;

import java.util.HashMap;

public class B {

	public static void main(String[] args) {
		int[] a = solution(new String[] {"aaaaaaaaaab","bbbbbbbbbbb"});
		System.out.println(a);
	}

	static public int[] solution(String[] S) {
		int M = S[0].length();
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < S.length; i++) {
				if (hm.containsKey(S[i].charAt(j))) {
					return new int[] { hm.get(S[i].charAt(j)), i, j };
				}
				hm.put(S[i].charAt(j), i);
			}
			hm.clear();
		}
		return new int[] {};
	}
}
