package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;

public class word {
	static String targetStr;
	static boolean finish = false;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		String[] str = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution("hit", "cog", str));
	}

	static public int solution(String begin, String target, String[] words) {
		boolean flag = true;
		targetStr = target;
		ArrayList<String> ar = new ArrayList();
		for (String str : words) {
			ar.add(str);
			if (target.equals(str))
				flag = false;
		}
		if (flag)
			return 0;
		dfs(ar, begin, 0);
		return result;
	}

	static void dfs(ArrayList<String> words, String begin, int cnt) {
		if (begin.equals(targetStr)) {
			result = result > cnt ? cnt : result;
			return;
		}
		if (words.isEmpty())
			return;
		boolean[] change = new boolean[words.size()];
		Arrays.fill(change, true);
		for (int s = 0; s < words.size(); s++) {
			int life = 0;
			for (int i = 0; i < words.get(s).length(); i++) {
				if (words.get(s).charAt(i) != begin.charAt(i))
					life++;
				if (life > 1) {
					change[s] = false;
					break;
				}
			}
		} // 바꿀수 있는지 없는지
		for (int i = 0; i < change.length; i++) {
			if (change[i]) {
				String newBeigin = null;
				ArrayList<String> temp = new ArrayList();
				for (int w = 0; w < words.size(); w++) {
					if (w == i) {
						newBeigin = words.get(w);
						continue;
					}
					temp.add(words.get(w));
				} // temp에 바꿀꺼 뺴고 다 넣음
				dfs(temp, newBeigin, cnt + 1);
			}
		}

	}
}
