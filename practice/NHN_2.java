package practice;

import java.util.ArrayList;

public class NHN_2 {

	public static void main(String[] args) {
		solution(2, 6, new int[][] { { 6, 2, 11, 0, 3, 5 }, { 6, 3, 0, 9, 0, 5 } });
	}

	private static void solution(int day, int width, int[][] blocks) {
		int[] height = new int[width];
		ArrayList<Integer> siment = new ArrayList<>();
		int result = 0;
		for (int i = 0; i < day; i++) {
			for (int j = 0; j < width; j++) {
				height[j] += blocks[i][j];
			}
			int[] temp = new int[width];
			for (int j = 0; j < width; j++) {
				if (height[j] > height[j + 1])
					temp[j] = 1;
			}
		}
		System.out.println(result);
	}
}
