package SummerCoding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programers_기지국설치 {
	// 2 : 07
	public static void main(String[] args) {
		System.out.println(solution(11, new int[] { 4, 11 }, 1));
	}

	static public int solution(int n, int[] stations, int w) {
		int start = 1;
		int end = n;
		int answer = 0;
		int width = 2 * w + 1;
		int right = 0;
		for (int i = 0; i < stations.length; i++) {
			int left = 0;
			if (i == 0) {
				left = stations[i] - w - 1;
				right = stations[i] + w;
			} else {
				int nowCover = right;
				if (stations[i] - w > nowCover) { // 왼쪽부분 설치할 필요 있을때
					left = stations[i] - w - nowCover - 1;
				}
				right = stations[i] + w;
			}
			if (left > 0) {
				answer += left % width == 0 ? left / width : ((left / width) + 1);
			}
			if (right >= n)
				break;
		}
		if (right >= n)
			return answer;
		else {
			int left = n - right;
			answer += left % width == 0 ? left / width : ((left / width) + 1);
			return answer;
		}
	}
}
