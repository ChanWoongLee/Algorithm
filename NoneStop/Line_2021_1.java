package NoneStop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Line_2021_1 {

	public static void main(String[] args) {

	}

	public String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < languages.length; i++) {
			map.put(languages[i], preference[i]);
		}
		ArrayList<Lan> forSort = new ArrayList<>();
		for (String str : table) {
			String[] strParse = str.split(" ");
			String nowJob = strParse[0];
			int nowScore = 0;
			for (int i = 1; i < strParse.length; i++) {
				nowScore += map.getOrDefault(strParse[i], 0);
			}
			forSort.add(new Lan(nowScore, nowJob));
		}
		Collections.sort(forSort);
		return forSort.get(0).job;
	}

	static class Lan implements Comparable<Lan> {
		int score;
		String job;

		public Lan(int score, String job) {
			super();
			this.score = score;
			this.job = job;
		}

		@Override
		public int compareTo(Lan o) {
			if (this.score != o.score)
				return Integer.compare(this.score, o.score);
			else {
				int com = this.job.compareTo(o.job);
				if(com > 0)
					return 1;
				else if(com < 0)
					return -1;
				else
					return 0;
			}
			
		}

	}
}
