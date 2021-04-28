package NoneStop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P_매뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		int[] course = { 2, 3, 5 };
		solution(orders, course);
	}

	static ArrayList<Integer> temp = new ArrayList<>();

	static public String[] solution(String[] orders, int[] course) {
		Map<String, Integer> map = new HashMap<>();

		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < course.length; i++) {
			int goal = course[i];
			map = new HashMap<>();
			for (int j = 0; j < orders.length; j++) {
				char[] charAr = orders[j].toCharArray();
				Arrays.sort(charAr);
				recur(charAr, 0, 0, goal, map);
			}
			Set<String> ks = map.keySet();
			int max = 0;
			for (String str : ks) {
				if (map.get(str) > max)
					max = map.get(str);
			}

			for (String str : ks) {
				if (map.get(str) == max)
					ans.add(str);
			}
		}
		Collections.sort(ans);
		String[] answer = new String[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}

	static void recur(char[] charAr, int index, int cnt, int max, Map<String, Integer> map) {
		if (cnt == max) {
			StringBuilder stb = new StringBuilder();
			for (int idx : temp) {
				stb.append(charAr[idx]);
			}
			map.put(stb.toString(), map.getOrDefault(stb.toString(), 1) + 1);
			return;
		}
		for (int i = index; i < charAr.length; i++) {
			temp.add(i);
			recur(charAr, i + 1, cnt + 1, max, map);
			temp.remove(temp.size() - 1);
		}
	}
}
