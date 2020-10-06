package SummerCoding;

import java.util.Arrays;

public class Programers_최고의집합 {

	public static void main(String[] args) {

	}

	public int[] solution(int n, int s) {
		if (n > s)
			return new int[] { -1 };
		int divide = s / n;
		int remainder = s % n;
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			if (remainder != 0) {
				answer[i] = divide + 1;
				remainder--;
			}else{
				answer[i] = divide;
			}
		}
		Arrays.sort(answer);
		return answer;
	}
}
