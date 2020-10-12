package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class K_B {

	public static void main(String[] args) {
		SolutionB b = new SolutionB();
		String[] a = b.solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 });
		for (String aa : a)
			System.out.println(aa);
	}

}

class SolutionB {
	static String[] temp;
	static HashMap<String, Integer> hashmap = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		ArrayList<String> result = new ArrayList<>();
		for (int i = 1; i <= course.length; i++) {
			temp = new String[course[i - 1]];
			for (int j = 0; j < orders.length; j++) {
				recur(0, 0, course[i - 1], orders[j].split(""));
			}
			int maxCnt = 0;
			for (String k : hashmap.keySet()) {
				if (hashmap.get(k) > maxCnt)
					maxCnt = hashmap.get(k);
			}
			for (String k : hashmap.keySet()) {
				if (hashmap.get(k) == maxCnt && maxCnt >= 2)
					result.add(k);
			}
			hashmap.clear();
		}

		Collections.sort(result);
		return result.toArray(new String[result.size()]);
	}

	static void recur(int index, int cnt, int maxCnt, String[] order) {
		if (cnt == maxCnt) {
			StringBuilder stb = new StringBuilder();
			String[] temptemp = Arrays.copyOf(temp, temp.length);
			Arrays.sort(temptemp);
			for (int i = 0; i < temptemp.length; i++) {
				stb.append(temptemp[i]);
			}

			if (hashmap.containsKey(stb.toString())) {
				hashmap.replace(stb.toString(), hashmap.get(stb.toString()) + 1);
			} else {
				hashmap.put(stb.toString(), 1);
			}
			return;
		}
		for (int i = index; i < order.length; i++) {
			temp[cnt] = order[i];
			recur(i + 1, cnt + 1, maxCnt, order);
		}
	}
}