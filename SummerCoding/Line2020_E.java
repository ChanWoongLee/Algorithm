package SummerCoding;

import java.util.ArrayList;

public class Line2020_E {

	public static void main(String[] args) {

	}

	static int totalnum;

	public int solution(int[] cards) {
		totalnum = cards.length;
		int answer = -1;
		playerA = 0;
		dealerA = 0;
		return answer;
	}

	static int playerA;
	static int dealerA;

	static int game(int start, int[] cards) {
		Person player = new Person();
		Person dealer = new Person();
		if (start + 3 >= totalnum)
			return -1;
		player.score += cards[start];
		start++;
		if (cards[start] == 1)
			player.A++;
		dealer.score += cards[start];
		start++;
		if (cards[start] == 1)
			dealer.A++;
		player.score += cards[start];
		start++;
		if (cards[start] == 1)
			player.A++;
		dealer.score = cards[start];
		start++;
		if (cards[start] == 1)
			dealer.A++;

		if (checkBlackJeck(player)) {

		}

		if (cards[start] == 1 || cards[start] >= 7) {
			if (player.score < 17) {
				while (pA != 0) {
					player += 10;
					pA--;
					if (player >= 17)
						break;
				}
				while (!(player >= 17)) {
					if (start >= totalnum)
						return -1;
					player += cards[start];
					if (cards[start] == 1) {
						if (player + 10 >= 17) {
							player += 10;
							start++;
							break;
						}
					}
					start++;
				}
			}
		} else if (cards[start] == 2 || cards[start] == 3) {

		}

		return 1;
	}

	static Person useA(Person p, int score, int want, int start, int[] cards) {
		int beforeScore = p.score;
		int beforeA = p.A;

		while (p.A != 0) {
			p.score += 10;
			p.A--;
			if (p.score >= want)
				return p;
		}
		p.score = beforeScore;
		p.A = beforeA;
		while (!(p.score >= want)) {
			if (start >= totalnum)
				return null;
			p.score += cards[start];
			if (cards[start] == 1) {
				if (p.score + 10 >= want) {
					p.score += 10;
					start++;
					break;
				}
			}
			start++;
		}
		return null;
	}

	static boolean checkBlackJeck(int player) {
		if (player == 21) {
			return true;
		}
		int tempA = playerA;
		int tempSocre = player;
		while (tempA != 0) {
			tempSocre += 10;
			tempA--;
			if (tempSocre == 21)
				return true;
		}
		return false;
	}

	static class Person {
		int A;
		int score;

	}
}
