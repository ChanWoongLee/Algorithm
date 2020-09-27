package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;

public class K_C_RE {

	public static void main(String[] args) {
		SolutionC_RE c = new SolutionC_RE();
		c.solution(
				new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
						"python frontend senior chicken 150", "cpp backend senior pizza 260",
						"java backend junior chicken 80", "python backend senior chicken 50" },
				new String[] { "java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
						"- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150" });
	}

	static class SolutionC_RE {
		public int[] solution(String[] info, String[] query) {
			int[] answer = {};
			ArrayList<ArrayList<String>> ar = new ArrayList<>();
			for (int i = 0; i < info.length; i++) {
				String[] parse = info[i].split(" ");
				ArrayList<String> into = new ArrayList<>(Arrays.asList(parse));
				ar.add(into);
			}
			ArrayList<Integer> result = new ArrayList<>();
			for (int i = 0; i < query.length; i++) {
				String q = query[i].replaceAll("and ", "").replaceAll("- ", "");
				String[] parse = q.split(" ");
				int score = Integer.parseInt(parse[parse.length-1]);
				ArrayList<String> check = new ArrayList<>();
				for (int j = 0; j < parse.length-1; j++) {
					check.add(parse[j]);
				}
				int count = 0;
				for (ArrayList<String> a : ar) {
					if (a.containsAll(check) && score <= Integer.parseInt(a.get(4))) {
						count++;
					}
				}
				result.add(count);
			}
			int[] res = new int[result.size()];
			for (int i = 0; i < result.size(); i++) {
				res[i] = result.get(i);
			}
			return answer;
		}
	}
}
