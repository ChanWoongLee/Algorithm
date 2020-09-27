package SummerCoding;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class K_C {

	public static void main(String[] args) {
		SolutionC c = new SolutionC();
		c.solution(
				new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
						"python frontend senior chicken 150", "cpp backend senior pizza 260",
						"java backend junior chicken 80", "python backend senior chicken 50" },
				new String[] { "java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
						"- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150" });
	}

}

class SolutionC {
	static public int[] solution(String[] info, String[] query) {
		int[] answer = {};
		ArrayList<User> user = new ArrayList<>();
		for (int i = 0; i < info.length; i++) {
			String[] parse = info[i].split(" ");
			user.add(new User(parse[0], parse[1], parse[2], parse[3], Integer.parseInt(parse[4])));
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < query.length; i++) {
			String q = query[i].replaceAll("and ", "");
			String[] parse = q.split(" ");
			ArrayList<User> uTemp = new ArrayList<>();
			for (User u : user) {
				uTemp.add(u);
			}
			for (int j = 0; j < parse.length; j++) {
				if (parse[j].equals("-"))
					continue;
				switch (j) {
				case 0:
					uTemp = (ArrayList<User>) uTemp.stream().filter(t -> t.a.equals(parse[0]))
							.collect(Collectors.toList());

					break;
				case 1:
					uTemp = (ArrayList<User>) uTemp.stream().filter(t -> t.b.equals(parse[1]))
							.collect(Collectors.toList());
					break;
				case 2:
					uTemp = (ArrayList<User>) uTemp.stream().filter(t -> t.c.equals(parse[2]))
							.collect(Collectors.toList());
					break;
				case 3:
					uTemp = (ArrayList<User>) uTemp.stream().filter(t -> t.d.equals(parse[3]))
							.collect(Collectors.toList());
					break;
				case 4:
					uTemp = (ArrayList<User>) uTemp.stream().filter(t -> t.score >= Integer.parseInt(parse[4]))
							.collect(Collectors.toList());
					break;

				}

			}
			result.add(uTemp.size());
		}
		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}
		return res;
	}

	static class User {
		String a, b, c, d;
		int score;

		public User(String a, String b, String c, String d, int score) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.score = score;
		}
	}
}
