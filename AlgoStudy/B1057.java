package AlgoStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class B1057 {
	static int kim;
	static int lim;
	static int result = 0;

	public static int tonerment1(int[] match, int start, int end, int deep) {// Â¦¼ö ¸ÕÆ®
		if (start == end)
			return 0;
		int mid = (start + end) / 2;
		tonerment1(match, start, mid, deep + 1);
		tonerment1(match, mid + 1, end, deep + 1);
		if ((match[start] == 0) && (match[end] == 0))
			return deep;
		else {
			result++;
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] match = new int[N + 1];
		kim = sc.nextInt();
		lim = sc.nextInt();
		for (int i = 1; i < N + 1; i++) {
			if (i == kim)
				match[i] = 0;
			else if (i == lim)
				match[i] = 0;
			else
				match[i] = i;
		}

		if (match[N] == 0) {
			int find = 0;
			for (int i = 1; i < N + 1; i++) {
				if (match[i] == 0) {
					find = i;
				}
			}
			if (find % 2 == 0)
				find--;
			find = N - find;
			while (true) {
				if (find == 1) {
					break;
				} else {
					find = find / 2;
					result++;
				}
			}
			System.out.println(result);
		} else {
		}
	}

}
