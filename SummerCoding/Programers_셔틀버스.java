package SummerCoding;

import java.util.ArrayList;

public class Programers_¼ÅÆ²¹ö½º {

	public static void main(String[] args) {

	}

	public String solution(int n, int t, int m, String[] timetable) {
		ArrayList<Crew> crew = new ArrayList<>();
		String[] strAr;
		for (String str : timetable) {
			strAr = str.split(":");
			crew.add(new Crew(Integer.parseInt(strAr[0]), Integer.parseInt(strAr[1])));
		}

		String answer = "";
		return answer;
	}

	static class Crew implements Comparable<Crew> {
		int start, end;

		public Crew(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Crew o) {
			if (o.start == this.start)
				return this.end - o.end;
			else
				return this.start - o.start;
		}
	}
}
