package SummerCoding;

import java.util.HashMap;

public class Line2020_A {

	public static void main(String[] args) {
		solution(new int[][] { { 1, 2 }, { 2, 1 }, { 3, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } });
	}

	static public int solution(int[][] boxes) {
		int answer = -1;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		for (int i = 0; i < boxes.length; i++) {
			if (hm.containsKey((Integer) boxes[i][0])) {
				hm.remove((Integer) boxes[i][0]);
				count++;
			} else {
				hm.put(boxes[i][0], i);
			}

			if (hm.containsKey((Integer) boxes[i][1])) {
				hm.remove((Integer) boxes[i][1]);
				count++;
			} else {
				hm.put(boxes[i][1], i);
			}
		}
		return boxes.length-count;
	}
}
