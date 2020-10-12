package SummerCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Programers_Â¡°Ë´Ù¸® {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 }, 3));

	}

	static public int solution(int[] stones, int k) {
		int answer = 0;
		int left = 0;
		int right = 200000000;

		while (left <= right) {
			int middle = (right + left) / 2;
			int cnt = 0;
			for (int i = 0; i < stones.length; i++) {
				if (stones[i] - middle <= 0) {
					cnt++;
				} else {
					cnt = 0;
				}
				if (cnt == k) {
					right = middle - 1;
					break;
				}
			}
			if (cnt < k) {
				left = middle + 1;
			}
			System.out.println(left +" "+ right);
		}

		return left;
	}
}
