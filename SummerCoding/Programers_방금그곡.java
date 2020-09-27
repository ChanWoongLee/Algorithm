package SummerCoding;

import java.util.ArrayList;
import java.util.Collections;

public class Programers_¹æ±Ý±×°î {
	public static void main(String[] args) {
		System.out.println(
				solution("CC#BCC#BCC#BCC#B", new String[] { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B " }));
	}

	static public String solution(String m, String[] musicinfos) {
		ArrayList<Song> ar = new ArrayList<>();
		for (int i = 0; i < musicinfos.length; i++) {
			String[] parse = musicinfos[i].split(",");
			String[] startTime = parse[0].split(":");
			String[] endTime = parse[1].split(":");
			String Music = parse[2];
			String gasa = parse[3];
			String initGasa = gasa;
			int diffH = Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]);
			int diffM = Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);
			if (diffM < 0) {
				diffH -= 1;
				diffM += 60;
			}
			int totalM = diffH * 60 + diffM;

			String forShap = gasa.replaceAll("#", "");
			int shapNum = gasa.length() - forShap.length();
			while (true) {
				if (initGasa.length() - shapNum > totalM) {
					int idx = 0;
					for (int j = 0; j < totalM; j++) {
						if (gasa.charAt(idx + 1) == '#') {
							idx++;
						}
						idx++;
					}
					gasa += gasa.substring(0, idx);
					break;
				}

				totalM -= initGasa.length() - shapNum;
				gasa += gasa;
			}

			for (int j = 0; j < gasa.length() - m.length(); j++) {
				if (m.equals(gasa.substring(j, j + m.length()))) {
					if (m.charAt(m.length() - 1) != '#' && gasa.charAt(j + m.length()) == '#')
						continue;
					ar.add(new Song(totalM, i, Music));
					break;
				}
			}

		}
		Collections.sort(ar);
		if (ar.size() == 0)
			return "'(None)'";
		else
			return ar.get(0).misic;
	}

	static class Song implements Comparable<Song> {
		int totalTime, idx;
		String misic;

		public Song(int totalTime, int idx, String music) {
			this.totalTime = totalTime;
			this.misic = music;
			this.idx = idx;
		}

		@Override
		public int compareTo(Song o) {
			if (o.totalTime == this.totalTime)
				return this.idx - o.idx;
			return o.totalTime - this.totalTime;
		}
	}
}
