package practice;

import java.util.ArrayList;

public class NHN_1 {

	public static void main(String[] args) {
		solution(17, 5, new char[] { 'B', 'D', 'I', 'M', 'P' }, 11,
				new int[] { 3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23 });
	}

	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		ArrayList<Character> ar = new ArrayList<>();
		int now = 66;
		for (int i = 0; i < numOfAllPlayers - 1; i++) {
			char person = (char) now;
			ar.add(person);
			now++;
		}
		ArrayList<Character> quick = new ArrayList<>();
		for (char c : namesOfQuickPlayers)
			quick.add(c);

		int[] visit = new int[91];
		visit[65] = 1;
		now = 65;
		int loc = 0;
		for (int i = 0; i < numOfGames; i++) {
			loc += numOfMovesPerGame[i];
			if (loc >= ar.size()) {
				loc %=  ar.size();
			} else if (loc < 0) {
				int plus = -numOfMovesPerGame[i];
				plus %= ar.size();
				loc -= plus;
				loc -= numOfMovesPerGame[i];
				if (loc < 0) {
					loc = ar.size() + loc;
				}
			}
			if (quick.contains(ar.get(loc))) {
				visit[now]++;
			} else {
				char movePlayer = ar.get(loc);
				ar.set(loc, (char) now);
				now = movePlayer;
				visit[now]++;
			}
			if(loc == 1)
				System.out.println("fefe");
		}
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i) + " " + visit[ar.get(i)]);
		}
		System.out.println((char) now + " " + visit[now]);
	}
}
