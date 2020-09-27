package SummerCoding;

public class Kakao2021_A {

	public static void main(String[] args) {

	}

	public String solution(int[] numbers, String hand) {
		String answer = "";
		int[][] loc = { { 0, 3, 1 }, { 1, 0, 0 }, { 2, 0, 1 }, { 3, 0, 2 }, { 4, 1, 0 }, { 5, 1, 1 }, { 6, 1, 2 },
				{ 7, 2, 0 }, { 8, 2, 1 }, { 9, 2, 2 }

		};
		int rightposR = 3;
		int rightposC = 0;
		int leftposR = 3;
		int leftposC = 2;
		for (int i = 0; i < numbers.length; i++) {
			int now = numbers[i];
			if (now == 1 || now == 4 || now == 7) {
				answer += "L";
				leftposR = loc[now][1];
				leftposC = loc[now][2];
			} else if (now == 3 || now == 6 || now == 9) {
				answer += "R";
				rightposR = loc[now][1];
				rightposC = loc[now][2];
			} else {
				int Rdist = Math.abs(loc[now][1] - rightposR) + Math.abs(loc[now][2] - rightposC);
				int Ldist = Math.abs(loc[now][1] - leftposR) + Math.abs(loc[now][2] - leftposC);

				if (Rdist < Ldist) {
					answer += "R";
					rightposR = loc[now][1];
					rightposC = loc[now][2];
				} else if (Rdist > Ldist) {
					answer += "L";
					leftposR = loc[now][1];
					leftposC = loc[now][2];
				} else {
					if (hand.equals("right")) {
						answer += "R";
						rightposR = loc[now][1];
						rightposC = loc[now][2];
					} else {
						answer += "L";
						leftposR = loc[now][1];
						leftposC = loc[now][2];
					}

				}

			}

		}
		return answer;
	}
}
