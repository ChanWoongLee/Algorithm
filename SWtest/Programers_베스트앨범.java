package SWtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Programers_º£½ºÆ®¾Ù¹ü {
	public static void main(String[] args) {
		solution(new String[] { "A","A"  }, new int[] { 5,5});
	}

	static public int[] solution(String[] genres, int[] plays) {
		ArrayList<Song>[] ar = new ArrayList[100];
		HashMap<String, Integer> hm = new HashMap<>();
		int[] forSort = new int[100];
		int start = 0;
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>();
		}
		for (int i = 0; i < genres.length; i++) {
			if (!hm.containsKey(genres[i])) {
				hm.put(genres[i], start++);
			}
			int strToNum = hm.get(genres[i]);
			ar[strToNum].add(new Song(i, plays[i]));
			forSort[strToNum] += plays[i];
		}
		ArrayList<Integer> result = new ArrayList<>();
		int Maxindex = 0;
		int Maxplays = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < start; j++) {
				if (Maxplays < forSort[j]) {
					Maxindex = j;
					Maxplays = forSort[j];
				}
			}
			if (Maxplays == 0)
				break;
			forSort[Maxindex] = 0;
			Collections.sort(ar[Maxindex]);
			if (ar[Maxindex].size() > 1) {
				result.add(ar[Maxindex].get(0).index);
				result.add(ar[Maxindex].get(1).index);
			} else {
				result.add(ar[Maxindex].get(0).index);
			}
			Maxindex = 0;
			Maxplays = 0;
			if (start == 1)
				break;
		}
		int[] r = new int[4];
		for (int i = 0; i < result.size(); i++) {
			r[i] = result.get(i);
		}

		return r;

	}

	static class Song implements Comparable<Song> {
		int index, plays;

		public Song(int index, int plays) {
			super();
			this.index = index;
			this.plays = plays;
		}

		@Override
		public int compareTo(Song o) {
			if (this.plays == o.plays) {
				return this.index - o.index;
			} else
				return o.plays - this.plays;
		}

	}
}
