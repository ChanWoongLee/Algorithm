package NoneStop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P_순위검색 {
	 // 완전 탐색(순열 ) , 이분탐색 (lower_bound) , 시간복잡도 생각
	public static void main(String[] args) {
		solution(
				new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
						"python frontend senior chicken 150", "cpp backend senior pizza 260",
						"java backend junior chicken 80", "python backend senior chicken 50" },
				new String[] { "java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
						"- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150" });
	}

	static Map<String, ArrayList<Integer>> map;
	static ArrayList<String> temp = new ArrayList<>();

	static public int[] solution(String[] info, String[] query) {
		ArrayList<Integer> ans = new ArrayList<>();
		map = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < info.length; i++) {
			String[] str = info[i].split(" ");
			recur("", 0, str);
		}
		Set<String> keySet = map.keySet();
		for(String str : keySet) {
			Collections.sort(map.get(str));
		}
		for (int i = 0; i < query.length; i++) {
			String[] parse = query[i].split(" ");
			String keyValue = "";
			for (int j = 0; j < parse.length - 1; j++) {
				if (parse[j].equals("and") || parse[j].equals("-"))
					continue;
				keyValue = keyValue + parse[j];
			}
			int score = Integer.parseInt(parse[parse.length - 1]);
			if (!map.containsKey(keyValue)) {
				ans.add(0);
				continue;
			}
			ArrayList<Integer> ar = map.get(keyValue);
			

			int start = 0;
			int end = ar.size() - 1;
			while (start <= end) {
				int mid = (start + end) / 2;

				if (score > ar.get(mid)) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			ans.add(ar.size() - start);
		}
		int[] answer = new int[ans.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}

	// static void recur(String[] str, int index, int cnt, int max) {
	// if (cnt == max) {
	// StringBuffer keyValue = new StringBuffer("");
	// ArrayList<Integer> save;
	// for (String s : temp)
	// keyValue.append(s);
	// System.out.println(keyValue.toString());
	// if (map.containsKey(keyValue.toString()))
	// save = map.get(keyValue.toString());
	// else
	// save = new ArrayList<>();
	// save.add(Integer.parseInt(str[str.length - 1]));
	// map.put(keyValue.toString(), save);
	// return;
	// }
	// for (int i = index; i < str.length - 1; i++) {
	// temp.add(str[i]);
	// recur(str, i + 1, cnt + 1, max);
	// temp.remove(temp.size() - 1);
	// }
	// }
	static void recur(String input, int depth, String[] info) {
		if (depth == 4) {
			ArrayList<Integer> save;
			if (map.containsKey(input))
				save = map.get(input);
			else
				save = new ArrayList<>();
			System.out.println(input + "점수:" + info[info.length - 1]);
			save.add(Integer.parseInt(info[info.length - 1]));
			map.put(input, save);
			return;
		}

		recur(input, depth + 1, info);
		recur(input + info[depth], depth + 1, info);
	}
}
