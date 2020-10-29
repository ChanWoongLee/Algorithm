package practice;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class TEESS {

	public static void main(String[] args) {
		StringBuffer stb = new StringBuffer();
		stb.append("0123456789");
		stb.delete(1, 3);
		stb.insert(0, 0.12);

		int a = 8;
		double b = Math.pow(8, 1.0 / 3.0);
		double c = 111.2212533;
		ArrayList<String> str = new ArrayList<>();
		str.add("hot");
		str.add("dot");
		str.add("dog");
		str.add("lot");
		str.add("log");

		System.out.println(ladderLength("hit", "cog", str));

	}

	static ArrayList<String> words;
	static boolean[] visit;
	static int result = Integer.MAX_VALUE;

	static public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		words = new ArrayList<>();
		for (String str : wordList) {
			words.add(str);
		}
		visit = new boolean[words.size()];
		bfs(beginWord, endWord, 0);
		if (result == Integer.MAX_VALUE)
			return 0;
		return result;
	}

	static void bfs(String now, String end, int cnt) {
		if (cnt > result)
			return;
		if (now.equals(end)) {
			System.out.println("여길온다고 ?");
			result = cnt + 1;
			return;
		}

		for (int i = 0; i < words.size(); i++) {
			if (visit[i] || getDiff(words.get(i), now) != 1)
				continue;
			visit[i] = true;
			bfs(words.get(i), end, cnt + 1);
			visit[i] = false;
		}
	}

	static int getDiff(String A, String B) {
		int ret = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i))
				ret++;
		}
		return ret;
	}
}
