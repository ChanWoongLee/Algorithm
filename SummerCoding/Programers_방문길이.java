package SummerCoding;

import java.util.ArrayList;

public class Programers_방문길이 {

	public static void main(String[] args) {

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public int solution(String dirs) {
		int answer = 0;
		int x = 0;
		int y = 0;
		int nextX = 0;
		int nextY = 0;
		ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
		for (int i = 0; i < dirs.length(); i++) {
			int beforeX = nextX;
			int beforeY = nextY;
			switch (dirs.charAt(i)) {
			case 'L':
				nextX += dx[0];
				nextY += dy[0];
				break;
			case 'R':
				nextX += dx[1];
				nextY += dy[1];
				break;
			case 'U':
				nextX += dx[2];
				nextY += dy[2];
				break;
			case 'D':
				nextX += dx[3];
				nextY += dy[3];
				break;
			}
			if (nextX < -5 || nextX > 5 || nextY > 5 || nextY < -5) {
				nextX = beforeX;
				nextY = beforeY;
				continue;
			}
			boolean dup = false;
			ArrayList<Integer> check = new ArrayList<>();
			check.add(nextX);
			check.add(nextY);
			for (ArrayList<Integer> a : ar) {
				if (a.get(0) == check.get(0) && a.get(1) == check.get(1)) {
					dup = true;
					break;
				}
			}
			if (dup)
				continue;
			else {
				answer++;
				ar.add(check);
			}
		}.
		return answer;
	}
}
