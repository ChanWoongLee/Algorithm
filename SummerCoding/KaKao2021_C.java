package SummerCoding;

import java.util.ArrayList;

public class KaKao2021_C {
	public static void main(String[] args) {
		String[] s = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		String[] ss = { "AA", "AB", "AC", "AA", "AC" };
		int[] res = solution(s);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	static public int[] solution(String[] gems) {
		ArrayList<String> ar = new ArrayList();
		for (int i = 0; i < gems.length; i++) {
			if (!ar.contains(gems[i])) {
				ar.add(gems[i]);
			}
		}
		int result = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		for (int i = 0; i <= gems.length - ar.size(); i++) {
			for (int j = i + ar.size() - 1; j < gems.length; j++) {

				if ((j - i) >= result)
					break;

				// i 부터 j 까지 사본다
				boolean[] visit = new boolean[ar.size()];
				int cnt = 0;
				for (int rot = i; rot <= j; rot++) {
					int idx = ar.indexOf(gems[rot]);
					if (!visit[idx]) {
						visit[idx] = true;
						cnt++;
					}
					if (cnt == ar.size())
						break;
				}
				if (cnt == ar.size()) {
					start = i + 1;
					end = j + 1;
					result = result > (j - i) ? (j - i) : result;
					if (result == ar.size()) {
						int[] answer = { start, end };
						return answer;
					}
				}
			}
		}
		int[] answer = { start, end };
		return answer;
	}
}
