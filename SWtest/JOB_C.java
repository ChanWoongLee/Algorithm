package SWtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class JOB_C {

	public static void main(String[] args) {
		int[] ar = solution(new int[] { 1, 4, 2, 6, 5, 3 }, 2);
		System.out.println("??");
	}

	static int[] C;
	static int len[] = new int[101]; // i에서 시작하는 최장 길이를 저장하는 dp 배열
	static int cnt[] = new int[101]; // i에서 시작하는 최장 길이 수열의 수를 저장하는 dp 배열

	static public int[] solution(int[] cookies, int k) {
		int n = cookies.length;
		C = cookies;
		Arrays.fill(len, -1);
		Arrays.fill(cnt, -1);
		ArrayList<Integer> result = new ArrayList<>();
		reconstruct(-1, k - 1, result);
		int[] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++)
			answer[i] = result.get(i);
		return answer;
	}

	static public void reconstruct(int begin, int skip, ArrayList<Integer> ar) {
		if (begin != -1)
			ar.add(C[begin]);
		ArrayList<Info> nextInfo = new ArrayList<>();
		for (int next = begin + 1; next < C.length; ++next) {
			if ((begin == -1 || C[begin] < C[next]) && lis(begin) == lis(next) + 1)
				nextInfo.add(new Info(C[next], next));
		}
		Collections.sort(nextInfo);
		for (int i = 0; i < nextInfo.size(); ++i) {
			int num = nextInfo.get(i).next;
			int cnt = count(num);
			if (skip >= cnt)
				skip -= cnt;
			else {
				reconstruct(num, skip, ar);
				break;
			}
		}
	}

	static int lis(int start) {
		if (len[start + 1] != -1)
			return len[start + 1];
		len[start + 1] = 1;
		for (int i = start + 1; i < C.length; i++) {
			if (start == -1 || C[i] > C[start]) {
				len[start + 1] = Math.max(len[start + 1], lis(i) + 1);
			}
		}
		return len[start + 1];
	}

	static int count(int start) {
		if (lis(start) == 1)
			return 1;
		if (cnt[start + 1] != -1)
			return cnt[start + 1];
		cnt[start + 1] = 0;
		for (int i = start + 1; i < C.length; i++) {
			if ((start == -1 || C[i] > C[start]) && lis(start) == lis(i) + 1) {
				cnt[start + 1] += count(i);
			}
		}
		return cnt[start + 1];
	}

	static class Info implements Comparable<Info> {
		int value, next;

		public Info(int value, int next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public int compareTo(Info o) {
			return this.value - o.value;
		}
	}
}
