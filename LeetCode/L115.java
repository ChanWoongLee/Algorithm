package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L115 {

	public static void main(String[] args) {
	}

	public int solution(int n, int[] lost, int[] reserve) {
		int[] std = new int[n + 1];
		Arrays.fill(std, 1);
		for (int l : lost) {
			std[l]--;
		}
		int result = n - lost.length;
		for (int r : reserve) {
			if (r - 1 >= 0 && std[r - 1] == 0) {
				std[r - 1]++;
				result++;
			} else if(std[r] == 0) {
				std[r]++;
				result++;
			} else if (r + 1 < n + 1 && std[r + 1] == 0) {
				std[r + 1]++;
				result++;
			}
		}
		return result;
	}
}
