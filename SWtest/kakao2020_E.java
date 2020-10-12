package SummerCoding;

import java.util.ArrayList;
import java.util.Arrays;

public class kakao2020_E {

	public static void main(String[] args) {
		System.out.println(solution(200, new int[] { 0, 10, 50, 80, 120, 160 }, new int[] { 1, 10, 5, 40, 30 }));
	}

	static int totalPeople;
	static ArrayList<Integer> WEAK;
	static int[] DIST;
	static int[] temp;
	static boolean[] tempVisit;
	static int WEAK_SIZE;
	static int Result = -1;
	static boolean finish = false;

	static public int solution(int n, int[] weak, int[] dist) {
		int answer = 0;
		WEAK = new ArrayList<>();
		for (int w : weak) {
			WEAK.add(w);
		}
		WEAK_SIZE = WEAK.size();
		for (int i = 0; i < WEAK_SIZE; i++) {
			WEAK.add(WEAK.get(i) + n);
		}
		DIST = dist;
		totalPeople = dist.length;

		for (int i = 1; i <= totalPeople; i++) {
			temp = new int[i];
			tempVisit = new boolean[dist.length];
			recur(0, i);
			if (finish)
				break;
		}
		return Result;
	}

	static void recur(int cnt, int maxCnt) {
		if (cnt == maxCnt) {
			for (int i = 0; i < WEAK_SIZE; i++) {
				int friendIndex = 0;
				int cover = 0;
				int start = i;
				for (start = i; start < i + WEAK_SIZE; start++) {
					if (cover == 0) {
						cover = WEAK.get(start) + temp[friendIndex++];
					} else {
						if (WEAK.get(start) > cover) {
							if (friendIndex >= temp.length)
								break;
							else {
								cover = WEAK.get(start) + temp[friendIndex++];
							}
						}

					}
				}
				if (start == i + WEAK_SIZE) {
					Result = temp.length;
					finish = true;
					return;
				}

			}
			return;
		}
		for (int i = 0; i < DIST.length; i++) {
			if (tempVisit[i])
				continue;
			tempVisit[i] = true;
			temp[cnt] = DIST[i];
			recur(cnt + 1, maxCnt);
			if (finish)
				return;
			tempVisit[i] = false;
		}
	}

}
