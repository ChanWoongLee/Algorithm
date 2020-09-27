package Inha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice5 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] cham = new int[102];
		int now = 1;
		while (true) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 0)
				break;
			else if (num < 21) {
				minheapsort(cham);
				for (int index = now - 1; index >= now - num; index--) {
					System.out.println(cham[index]);
					cham[index] = 0;
				}
				now = now - num;
			} else {
				cham[now] = num;
				now++;
			}
		}

	}

	static void maxheapsort(int[] num) {
		int end = num.length;
		for (int i = end / 2; i >= 1; i--) {
			heapify(num, i, end);
		}
		for (int i = end - 1; i >= 1; i--) {
			int temp = num[1];
			num[1] = num[i];
			num[i] = temp;
			heapify(num, 1, i);
		}
	}

	static void heapify(int[] num, int start, int end) {
		if (start * 2 >= end)
			return;

		int target_index = start * 2;
		if (start * 2 + 1 < end) {
			if (num[start * 2] < num[start * 2 + 1])
				target_index = start * 2 + 1;
		}
		if (num[target_index] >= num[start]) {
			int temp = num[target_index];
			num[target_index] = num[start];
			num[start] = temp;
			heapify(num, target_index, end);
		} else
			return;

	}

	static void minheapsort(int[] num) {
		int end = num.length;
		for (int i = end / 2; i >= 1; i--) {
			minheapify(num, i, end);
		}
		for (int i = end - 1; i >= 1; i--) {
			int temp = num[1];
			num[1] = num[i];
			num[i] = temp;
			minheapify(num, 1, i);
		}
	}

	static void minheapify(int[] num, int start, int end) {
		if (start * 2 >= end)
			return;

		int target_index = start * 2;
		if (start * 2 + 1 < end) {
			if (num[start * 2] > num[start * 2 + 1])
				target_index = start * 2 + 1;
		}
		if (num[target_index] <= num[start]) {
			int temp = num[target_index];
			num[target_index] = num[start];
			num[start] = temp;
			minheapify(num, target_index, end);
		} else
			return;

	}
}
